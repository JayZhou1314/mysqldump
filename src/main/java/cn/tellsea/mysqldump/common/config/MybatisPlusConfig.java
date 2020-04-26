package cn.tellsea.mysqldump.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis plus 配置
 *
 * @author: Tellsea
 * @date : 2020/3/2
 */
@Configuration
@MapperScan("cn.tellsea.mysqldump.*.mapper")
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
