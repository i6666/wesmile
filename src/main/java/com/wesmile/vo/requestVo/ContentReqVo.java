package com.wesmile.vo.requestVo;

import javax.validation.constraints.NotEmpty;

/**
 * Created by zma on 2019/06/12
 */
public class ContentReqVo {

    @NotEmpty
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
