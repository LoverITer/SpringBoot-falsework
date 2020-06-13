package top.easyblog;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


/**
 * 项目启动方法
 * @author fuce
 *
 */
@EnableTransactionManagement
@EnableWebMvc
@MapperScan(basePackages = "top.easyblog.mapper")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ApplicationStarter {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationStarter.class, args);
    }
}
