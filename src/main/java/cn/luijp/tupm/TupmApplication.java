package cn.luijp.tupm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.luijp.tupm.Pojo.Mapper")
public class TupmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TupmApplication.class, args);
    }

}
