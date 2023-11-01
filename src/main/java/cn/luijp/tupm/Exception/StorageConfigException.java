package cn.luijp.tupm.Exception;

import cn.luijp.tupm.Enum.ReposCodeEnum;

public class StorageConfigException extends RuntimeException{
    ReposCodeEnum reposCodeEnum;
    public StorageConfigException(ReposCodeEnum reposCodeEnum){
        super();
        this.reposCodeEnum = reposCodeEnum;
    }
    public ReposCodeEnum GetExceptionCode(){
        return reposCodeEnum;
    }
}
