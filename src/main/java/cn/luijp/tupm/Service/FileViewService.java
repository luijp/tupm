package cn.luijp.tupm.Service;

import cn.luijp.tupm.Exception.FileViewException;
import cn.luijp.tupm.Pojo.FileUpload;
import cn.luijp.tupm.Service.Impl.ViewFileClass;
import org.springframework.core.io.Resource;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Dictionary;

public interface FileViewService {
    public ViewFileClass ViewFile(int TargetId) throws MalformedURLException,FileViewException;
}
