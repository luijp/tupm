package cn.luijp.tupm.Enum;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;

public enum ReposCodeEnum {
    SUCCESS(200,"SUCCESS"),
    FAIL(500, "FAIL"),
    PAGE_NOT_FOUND(404, "PAGE_NOT_FOUND"),
    //上传文件为空
    FILE_IS_EMPTY(-10, "FILE_IS_EMPTY"),
    //指定ID配置文件未找到
    SIT_CONFIG_NOT_FOUND(-11, "SIT_CONFIG_NOT_FOUND"),
    //删除配置文件失败
    SITE_CONFIG_DELETE_FAILED(-12, "SITE_CONFIG_DELETE_FAILED"),
    //创建配置文件失败
    SITE_CONFIG_CREATE_FAILED(-13, "SITE_CONFIG_CREATE_FAILED"),
    //文件上传失败
    FILE_UPLOAD_FAILED(-14, "FILE_UPLOAD_FAILED"),
    FILE_UPLOAD_MAX_SIZE(-18, "FILE_UPLOAD_MAX_SIZE"),
    //指定储存策略未找到
    STORAGE_CONFIG_GET_BY_ID_FAILED(-15, "STORAGE_CONFIG_GET_BY_ID_FAILED"),
    //删除储存策略失败
    STORAGE_CONFIG_DELETE_FAILED(-16, "STORAGE_CONFIG_DELETE_FAILED"),
    //插入储存策略失败
    STORAGE_CONFIG_INSERT_FAILED(-17, "STORAGE_CONFIG_INSERT_FAILED")

    ;

    @Getter
    private final Integer Code;
    @Getter
    private final String Message;

    ReposCodeEnum(int Code, String Message){
        this.Code = Code;
        this.Message = Message;
    }


}
