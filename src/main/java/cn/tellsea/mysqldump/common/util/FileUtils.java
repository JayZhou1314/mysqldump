package cn.tellsea.mysqldump.common.util;

import cn.tellsea.mysqldump.common.consts.MysqlDumpConst;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文件上传工具类
 *
 * @author Tellsea
 * @date 2019/8/20
 */
@Slf4j
public class FileUtils {

    public static final String DATE_TYPE_SLASH = "yyyy/MM/dd";

    /**
     * 下载文件
     *
     * @param filePath 访问路径
     * @param fileName 下载文件名
     * @param response
     */
    public static void download(String filePath, String fileName, HttpServletResponse response) {
        File file = new File(MysqlDumpConst.SAVE_POSITION + filePath);
        if (file.exists()) {
            response.setHeader("content-type", "application/octet-stream");
            response.setContentType("application/octet-stream");
            // 下载文件能正常显示中文
            try {
                response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 实现文件下载
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                log.error("下载错误");
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            log.error("该文件不存在");
        }
    }

    /**
     * 迭代删除文件夹
     *
     * @param dirPath 文件夹路径
     */
    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            } else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }

    /**
     * 获得保存路径
     *
     * @param folder
     * @param dateFormat
     * @return 例如：/aaa/2020/04/11/
     */
    public static String getDatePath(String folder, String dateFormat) {
        String date = new SimpleDateFormat(dateFormat).format(new Date());
        StringBuffer path = new StringBuffer();
        path.append("/").append(folder).append("/").append(date).append("/");
        return path.toString();
    }
}
