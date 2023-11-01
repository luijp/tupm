package cn.luijp.tupm.Exception.Handler;

import cn.luijp.tupm.Enum.ReposCodeEnum;
import cn.luijp.tupm.Utils.Repos;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class ExceptionOtherHandler {
    @ExceptionHandler(Exception.class)
    public Repos<Object> handleException(Exception ex){
        log.info(Arrays.toString(ex.getStackTrace()));
        return Repos.fail(ReposCodeEnum.FAIL);
    }
}
