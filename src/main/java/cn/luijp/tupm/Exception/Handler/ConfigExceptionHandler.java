package cn.luijp.tupm.Exception.Handler;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Exception.ConfigException;
import cn.luijp.tupm.Utils.Repos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ConfigExceptionHandler {

    @ExceptionHandler(ConfigException.class)
    public Repos<Object> handleConfigException(ConfigException ex){
        ReposCodeEnum reposCodeEnum = ex.GetExceptionCode();
        log.info(reposCodeEnum.toString());
        return Repos.fail(reposCodeEnum);
    }
}
