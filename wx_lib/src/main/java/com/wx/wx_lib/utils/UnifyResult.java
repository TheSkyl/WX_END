package com.wx.wx_lib.utils;

import io.swagger.annotations.ApiModelProperty;

import java.util.HashMap;
import java.util.Map;

public class UnifyResult {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String,Object> data = new HashMap<String, Object>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    //成功静态方法
    public static UnifyResult ok() {
        UnifyResult r = new UnifyResult();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static UnifyResult error() {
        UnifyResult r = new UnifyResult();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public UnifyResult success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public UnifyResult message(String message){
        this.setMessage(message);
        return this;
    }

    public UnifyResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public UnifyResult data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public UnifyResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }

}
