package cn.luijp.tupm.Exception;

import cn.luijp.tupm.Enum.ReposCodeEnum;

public class FileUploadException extends RuntimeException{
    ReposCodeEnum reposCodeEnum;
    public FileUploadException(ReposCodeEnum reposCodeEnum) {
        super();
        this.reposCodeEnum = reposCodeEnum;
    }
    public ReposCodeEnum GetExceptionCode(){
        return reposCodeEnum;
    }
}
