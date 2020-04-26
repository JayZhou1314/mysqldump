package cn.tellsea.mysqldump.file.service.impl;

import cn.tellsea.mysqldump.common.util.FileUtils;
import cn.tellsea.mysqldump.file.service.FileService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件 接口实现类
 *
 * @author Tellsea
 * @date 2020/4/11
 */
@Service
public class FileServiceImpl implements FileService {

    @Override
    public void downloadFile(String filePath, String fileName, HttpServletRequest request, HttpServletResponse response) {
        FileUtils.download(filePath, fileName, response);
    }
}
