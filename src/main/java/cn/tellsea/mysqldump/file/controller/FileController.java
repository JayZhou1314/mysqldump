package cn.tellsea.mysqldump.file.controller;

import cn.tellsea.mysqldump.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 文件 控制器
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("downloadFile")
    public void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        fileService.downloadFile(filePath, fileName, request, response);
    }
}
