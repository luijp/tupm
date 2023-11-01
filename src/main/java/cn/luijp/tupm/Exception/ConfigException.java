package cn.luijp.tupm.Exception;

import cn.luijp.tupm.Enum.ReposCodeEnum;

public class ConfigException extends RuntimeException{
    ReposCodeEnum reposCodeEnum;
    public ConfigException(ReposCodeEnum reposCodeEnum) {
        super();
        this.reposCodeEnum = reposCodeEnum;
    }
    public ReposCodeEnum GetExceptionCode(){
        return reposCodeEnum;
    }
}
