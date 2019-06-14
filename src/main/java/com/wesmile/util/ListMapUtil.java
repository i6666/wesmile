package com.wesmile.util;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Utils
 */
public class ListMapUtil {

	public static <X, T> Map<X, T> listToMap(List<T> list, String key) {
		Map<X, T> map = new HashMap<X, T>(list.size());
		for (T tem : list) {
			if(tem!=null) {
				X temKey = (X) ReflectionUtil.getFieldValue(tem, key);
				if (temKey != null) {
					map.put(temKey, tem);
				}
			}

		}
		return map;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    public static <X, T> Map<X, T> mapListToMap(List<T> list, String key) {
        Map<X, T> map = new HashMap<X, T>(list.size());
        for (T tem : list) {
            Map m = (Map) tem;
            X temKey = (X) m.get(key);
            if (temKey != null) {
                map.put(temKey, tem);
            }

        }
        return map;
    }

	public static <X, T> Map<X, List<T>> listToMapList(List<T> list, String key) {
		Map<X, List<T>> map = new HashMap<X, List<T>>(list.size());
		for (T tem : list) {
			X temKey = (X) ReflectionUtil.getFieldValue(tem, key);
			if (temKey != null) {
				List<T> temList = map.get(temKey);
				if (temList == null) {
					temList = new ArrayList<T>();
					map.put(temKey, temList);
				}
				temList.add(tem);
			}
		}
		return map;
	}

	public static <X, Y, T> Map<X, List<Y>> listToMapSetAttr(List<T> list, String key1, String key2) {
		Map<X, List<Y>> map = new HashMap<X, List<Y>>(list.size());
		for (T tem : list) {
			X temKey1 = (X) ReflectionUtil.getFieldValue(tem, key1);
			Y temKey2 = (Y) ReflectionUtil.getFieldValue(tem, key2);
			if (temKey1 != null) {
				List<Y> temList = map.get(temKey1);
				if (temList == null) {
					temList = new ArrayList<Y>();
					map.put(temKey1, temList);
				}
				if (!temList.contains(temKey2)) {
					temList.add(temKey2);
				}
			}
		}
		return map;
	}

	public static <X> List<X> listToKeyList(List list, String key) {
		List<X> keyList = new ArrayList<X>();
		for (Object tem : list) {
			X temKey = (X) ReflectionUtil.getFieldValue(tem, key);
			if (temKey != null) {
				if (!keyList.contains(temKey)) {
					keyList.add(temKey);
				}
			}
		}
		return keyList;
	}

	public static <X, Y, T> Map<X, Map<Y, T>> listToMapMap(List<T> list, String key1, String key2) {
		Map<X, Map<Y, T>> map = new HashMap<X, Map<Y, T>>(list.size());
		for (T tem : list) {
			X temKey1 = (X) ReflectionUtil.getFieldValue(tem, key1);
			if (temKey1 != null) {
				Map<Y, T> temMap = map.get(temKey1);
				if (temMap == null) {
					temMap = new HashMap<Y, T>(list.size());
					map.put(temKey1, temMap);
				}
				Y temKey2 = (Y) ReflectionUtil.getFieldValue(tem, key2);
				temMap.put(temKey2, tem);
			}
		}
		return map;
	}

	/**
	 * 排序
	 * 
	 * @param ids
	 * @param list
	 * @param key
	 * @return
	 */
	public static <X, T> List<T> sortList(List<X> ids, List<T> list, String key) {

		Map<X, T> listMap = ListMapUtil.listToMap(list, key);

		List<T> result = new ArrayList<>();
		for (X cid : ids) {
			result.add(listMap.get(cid));
		}
		return result;
	}
	
	/**
     * 排序
     * 
     * @param ids
     * @param list
     * @param key
     * @return
     */
    public static <X, T> List<T> sortMapList(List<X> ids, List<T> list, String key) {

        Map<X, T> listMap = ListMapUtil.mapListToMap(list, key);

        List<T> result = new ArrayList<>();
        for (X cid : ids) {
            result.add(listMap.get(cid));
        }
        return result;
    }

	/**
	 * 按指定大小，分隔集合，将集合按规定个数分为n个部分
	 *
	 * @param list List
	 * @param len int
	 * @return List
	 */
	public static List<List<?>> splitList(List<?> list, int len) {
		if (list == null || list.size() == 0 || len < 1) {
			return null;
		}

		List<List<?>> result = new ArrayList<>();

		int size = list.size();
		int count = (size + len - 1) / len;


		for (int i = 0; i < count; i++) {
			List<?> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
			result.add(subList);
		}
		return result;
	}

	public static void main(String[] args) {
		List<Long> aa = new ArrayList<>();
		aa.add(1L);
		aa.add(2L);
		aa.add(3L);
		aa.add(4L);
		aa.add(5L);
		aa.add(6L);
		aa.add(7L);
		aa.add(8L);
		aa.add(9L);
		aa.add(10L);
		aa.add(11L);
		aa.add(12L);
		aa.add(13L);
		aa.add(14L);
		aa.add(15L);
		aa.add(16L);
		int a = 18;
		List<List<?>> lists = splitList(aa, 5);
		System.out.println(lists);
	}

}
