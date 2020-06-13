package top.easyblog.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 读取项目相关配置
 * 
 * @author huangxin
 */
@Data
@Component
@ConfigurationProperties(prefix = "project")
public class ProjectConfig {
    /** 项目名称 */
    @Value(value = "${project.name}")
    private String name;
    /** 版本 */
    @Value(value = "${project.version}")
    private String version;
    @Value(value = "${project.engineering-code}")
    private String EngineeringCode;
}
