package cn.luijp.tupm.Enum;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ReposCodeEnum {
    SUCCESS(200),
    FAIL(500),
    PAGE_NOT_FOUND(404),
    //上传文件为空
    FILE_IS_EMPTY(-10),
    //指定ID配置文件未找到
    SIT_CONFIG_NOT_FOUND(-11),
    //删除配置文件失败
    SITE_CONFIG_DELETE_FAILED(-12),
    //创建配置文件失败
    SITE_CONFIG_CREATE_FAILED(-13),
    //文件上传失败
    FILE_UPLOAD_FAILED(-14),
    //指定储存策略未找到
    STORAGE_CONFIG_GET_BY_ID_FAILED(-15),
    //删除储存策略失败
    STORAGE_CONFIG_DELETE_FAILED(-16),
    //插入储存策略失败
    STORAGE_CONFIG_INSERT_FAILED(-17)
    ;

    private final int Code;

    ReposCodeEnum(int Code){
        this.Code = Code;
    }

    @JsonValue
    public Integer getCode(){
        return Code;
    }


}
