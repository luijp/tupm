package cn.luijp.tupm.Pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
@TableName("`SiteConfig`")
public class SiteConfig {
    @TableId
    private Integer id;
    private String name;
    private String value;
}
