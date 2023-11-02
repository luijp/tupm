package cn.luijp.tupm.Service.Impl;

import cn.luijp.tupm.Pojo.FileUpload;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

@Data
public class ViewFileClass {
    private Resource resource;
    private FileUpload fileUpload;
}
