package cn.luijp.tupm.Exception;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Utils.Repos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.net.MalformedURLException;

@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(ConfigException.class)
    public Repos<Object> handleConfigException(ConfigException ex){
        ReposCodeEnum reposCodeEnum = ex.GetExceptionCode();
        log.info(reposCodeEnum.toString());
        return Repos.fail(reposCodeEnum);
    }

    @Autowired
    private Environment environment;

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Repos<Object> handleMaxUploadSize(MaxUploadSizeExceededException ex) {
        log.info(ex.getMessage()
                + " max-file-size: " + environment.getProperty("spring.servlet.multipart.max-file-size")
                + " max-request-size: " + environment.getProperty("spring.servlet.multipart.max-request-size") );
        return Repos.fail(ReposCodeEnum.FILE_UPLOAD_MAX_SIZE,ReposCodeEnum.FILE_UPLOAD_MAX_SIZE.getMessage() + " max-file-size: " + environment.getProperty("spring.servlet.multipart.max-file-size")
                + " max-request-size: " + environment.getProperty("spring.servlet.multipart.max-request-size") );
    }

    @ExceptionHandler(FileViewException.class)
    public Repos<Object> handleFileViewException(FileViewException ex){
        ex.printStackTrace();
        log.warn(ex.getMessage());
        return Repos.fail(ex.GetExceptionCode());
    }

    @ExceptionHandler(MalformedURLException.class)
    public Repos<Object> handleMalformedURLException(MalformedURLException ex){
        ex.printStackTrace();
        log.warn(ex.getMessage());
        return Repos.fail(ReposCodeEnum.FILE_UPLOADED_BROKEN);
    }

    @ExceptionHandler(Exception.class)
    public Repos<Object> handleException(Exception ex){
        ex.printStackTrace();
        log.info(ex.getMessage());
        return Repos.fail(ReposCodeEnum.FAIL);
    }
}
