package cn.luijp.tupm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baomidou.mybatisplus.samples.quickstart.mapper")
public class TupmApplication {

    public static void main(String[] args) {
        SpringApplication.run(TupmApplication.class, args);
    }

}
