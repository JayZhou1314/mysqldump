package cn.tellsea.mysqldump;

import cn.tellsea.mysqldump.backup.entity.MysqlDump;
import cn.tellsea.mysqldump.backup.service.DataBaseService;
import cn.tellsea.mysqldump.backup.service.MysqlDumpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@SpringBootTest
class MysqlDumpApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private MysqlDumpService mysqlDumpService;
    @Autowired
    private DataBaseService dataBaseService;

    @Test
    public void test() {
        System.out.println(txt2String(new File("D:\\Workspace\\IDEAWorkspace\\mysqldump\\mysqldump-static\\default\\2020\\04\\26\\8e82cb5b_5648_4022_ae5f_2b774325b5b3.sql")));
    }

    public static String txt2String(File file) {
        StringBuilder result = new StringBuilder();
        try {
            //构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            //使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                result.append(System.lineSeparator() + s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @Test
    public void test2() {
        MysqlDump mysqlDump = new MysqlDump();
        mysqlDump.setIp("127.0.0.1");
        mysqlDump.setPort(3306);
        mysqlDump.setUserName("root");
        mysqlDump.setPassword("123456");
        mysqlDump.setDatabaseName("sunday_basea");
        System.out.println(dataBaseService.connection(mysqlDump));
    }
}
