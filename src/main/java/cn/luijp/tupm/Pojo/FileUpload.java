package cn.luijp.tupm.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
@Data
@TableName("`FileUpload`")
public class FileUpload {
    @TableId
    private Integer id;
    private String storagefolder;
    private String storagename;
    private String originname;
    private Timestamp createtime;
    private Boolean isdelete;
}
