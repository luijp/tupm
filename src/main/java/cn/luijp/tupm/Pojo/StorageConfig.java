package cn.luijp.tupm.Pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
@TableName("StorageConfig")
public class StorageConfig {
    @TableId
    private Integer id;
    private Integer target;
    private String localfilepath;
    private String s3Ak;
    private String s3Sk;
    private String s3Region;
    private String s3Bucketname;


}
