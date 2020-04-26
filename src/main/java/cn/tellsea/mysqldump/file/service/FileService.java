package cn.tellsea.mysqldump.file.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件 接口
 *
 * @author Tellsea
 * @date 2020/4/11
 */
public interface FileService {

    void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response);
}
