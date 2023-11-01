package cn.luijp.tupm.Enum;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ReposCodeEnum {
    SUCCESS(200),
    FAIL(500),
    PAGE_NOT_FOUND(404),
    //上传文件为空
    FILE_IS_EMPTY(-10)
    ;

    private final int Code;

    ReposCodeEnum(int Code){
        this.Code = Code;
    }

    @JsonValue
    public int getCode(){
        return Code;
    }


}
