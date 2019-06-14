package com.wesmile.util.cos;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.AnonymousCOSCredentials;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Transfer;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.TransferProgress;
import com.qcloud.cos.transfer.Upload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 腾讯云COS  上传/下载相关工具
 * Created by zma on 2019/06/13
 */
@Slf4j
public class CosClientUtil {

    public static String accessKey = "AKIDSkrnZ1T4d1HNJ8tzskRwHSkf2Mo5Y4nT";
    public static  String secretKey = "M8qPzc4PYVn270hDYqFVdgXG9uVzKTSF";
    public static  String regionName = "ap-shanghai";
    /**
     *  上传文件, 根据文件大小自动选择简单上传或者分块上传。
     * @param file 文件
     * @param bucketName 存储桶名称
     * @param filePath 路径输入目录名称即可，示例：aaa
     * @return 可访问url
     */
    public static String uploadFile(File file,String bucketName,String filePath) {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSClient cosclient = getBasicCosClient();
        // bucket名需包含appid
        ExecutorService threadPool = Executors.newFixedThreadPool(32);
        // 传入一个threadPool, 若不传入线程池, 默认TransferManager中会生成一个单线程的线程池。
        TransferManager transferManager = new TransferManager(cosclient, threadPool);
        String key = filePath +"/"+ file.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        try {
            // 返回一个异步结果Upload, 可同步的调用waitForUploadResult等待upload结束, 成功返回UploadResult, 失败抛出异常.
            long startTime = System.currentTimeMillis();
            Upload upload = transferManager.upload(putObjectRequest);
            showTransferProgress(upload);
            UploadResult uploadResult = upload.waitForUploadResult();
            long endTime = System.currentTimeMillis();
            log.debug("used time: " + (endTime - startTime) / 1000);
            log.debug(uploadResult.getETag());
        } catch (InterruptedException | CosClientException e) {
            e.printStackTrace();
        }
        transferManager.shutdownNow();
        // 设置URL过期时间为10年 3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = cosclient.generatePresignedUrl(bucketName, key, expiration);
        if (url != null) {
            return url.toString();
        }
        return null;
    }


    // Prints progress while waiting for the transfer to finish.
    private static void showTransferProgress(Transfer transfer) {
        log.debug(transfer.getDescription());
        do {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
            TransferProgress progress = transfer.getProgress();
            long so_far = progress.getBytesTransferred();
            long total = progress.getTotalBytesToTransfer();
            double pct = progress.getPercentTransferred();
            System.out.printf("[%d / %d]\n", so_far, total);
        } while (!transfer.isDone());
        log.debug(transfer.getState().toString());
    }

    /**
     *  上传图片，根据图片网络地址直接上传
     * @param imgUrl 文件
     * @param bucketName 存储桶名称
     * @param filePath 路径输入目录名称即可，示例：aaa
     * @return 可访问url
     */
    public static String uploadImgUrl(String imgUrl,String bucketName,String filePath) {
        //通过输入流获取图片数据
        COSClient cosclient = getBasicCosClient();
        String filename = generateFilename(imgUrl);
        String key = filePath +"/"+ filename;
        Date expirationTime = new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        URL putUrl = cosclient.generatePresignedUrl(bucketName, key, expirationTime, HttpMethodName.PUT);
        try {
            URL url = new URL(imgUrl);
            InputStream inStream = url.openConnection().getInputStream();
            HttpURLConnection connection = (HttpURLConnection) putUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("PUT");
            // 写入要上传的数据
            FileCopyUtils.copy(inStream,connection.getOutputStream());
            int responseCode = connection.getResponseCode();
            log.debug("Service returned response code " + responseCode);
        } catch (MalformedURLException e) {
            log.error("图片链接异常：imgUrl ={}", imgUrl, e);
        } catch (IOException e) {
            log.error("图片处理发生异常：imgUrl ={}", imgUrl, e);
        }
        GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
        Date expirationDate = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        req.setExpiration(expirationDate);
        URL url = cosclient.generatePresignedUrl(req);
        cosclient.shutdown();
        if (url != null) {
            return url.toString();
        }
        return null;
    }

    /**
     * 上传图片，根据图片网络地址直接上传默认路径
     * @param imgUrl
     * @return
     */
    public static String uploadImgUrl(String imgUrl) {
        String bucketName = "test-1259417364";
        String filePath = "aaa";
      return uploadImgUrl(imgUrl,bucketName,filePath);
    }
    /**
     * 根据imgUrl生成随机文件名
     * @param imgUrl
     * @return
     */
    private static String generateFilename(String imgUrl) {
        String extName = imgUrl.substring(imgUrl.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return  uuid+extName;
    }

    /**
     * 获取基础cos客户端
     * @return COSClient
     */
    public static COSClient getBasicCosClient() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(accessKey, secretKey);
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        // 3 生成cos客户端
        return new COSClient(cred, clientConfig);
    }
    /**
     * 获取匿名身份cos客户端 生成的预下载链接不包含签名
     * @return COSClient
     */
    public static COSClient getAnonymousClient() {
        // 1 初始化用户身份信息, 匿名身份不用传入ak sk
        COSCredentials cred = new AnonymousCOSCredentials();
        // 2 设置bucket的区域, COS地域的简称请参照 https://www.qcloud.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing-1"));
        // 3 生成cos客户端
        return new COSClient(cred, clientConfig);
    }


    public static void main(String[] args) throws Exception {
        String imgUrl = "http://wx2.sinaimg.cn/bmiddle/005PmRirgy1g3fp8un3roj30yi1pctj3.jpg";
        String newUrl = uploadImgUrl(imgUrl);
        System.out.println(newUrl);
    }


}
