package cn.luijp.tupm.Exception;

import cn.luijp.tupm.Enum.ReposCodeEnum;

public class FileViewException extends RuntimeException{
    ReposCodeEnum reposCodeEnum;
    public FileViewException(ReposCodeEnum reposCodeEnum) {
        super();
        this.reposCodeEnum = reposCodeEnum;
    }
    public ReposCodeEnum GetExceptionCode(){
        return reposCodeEnum;
    }
}
