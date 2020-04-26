package cn.tellsea.mysqldump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * MySQL 备份恢复系统
 *
 * @author Tellsea
 * @date 2020-4-22
 */
@SpringBootApplication
public class MysqlDumpApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlDumpApplication.class, args);
    }

}
