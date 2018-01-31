package com.cherrish.cloud.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ccl
 * @time 2018-01-31 18:10
 * @name FileUtil
 * @desc:
 */
@Slf4j
public class FileUtil {
    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        BufferedReader reader = null;
        FileInputStream fis = null;
        try {
            File f = new File(fileName);
            if (f.isFile() && f.exists()) {
                fis = new FileInputStream(f);
                reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (!"".equals(line)) {
                        list.add(line);
                    }
                }
            }
        } catch (Exception e) {
            log.error("readFile", e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                log.error("InputStream关闭异常", e);
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                log.error("FileInputStream关闭异常", e);
            }
        }
        return list;
    }
}
