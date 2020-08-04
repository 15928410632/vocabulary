package com.vankeytech.vocabulary.adapter;

import com.hankcs.hanlp.corpus.io.IIOAdapter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;

/**
 * 文件读取处理器
 *
 * @author liuheng
 * @date 2020/7/31 14:20
 */
public class ResourceFileIOAdapter implements IIOAdapter {

    private static final String SEPARATE = "/";
    private static final String CUSTOMIZE = "customize";

    @Override
    public InputStream open(String path) throws IOException {
        boolean isCache = path.endsWith("bin");
        if (path.startsWith(CUSTOMIZE)){
            path = path.substring(CUSTOMIZE.length() + 1);
            return ClassUtils.getDefaultClassLoader().getResourceAsStream(path);
        }else {
            if (path.contains(SEPARATE)) {
                path = path.substring(path.indexOf("/") + 1);
            }
            if (isCache) {
                path = "dictionary/cache/" + path;
            } else {
                path = "dictionary/" + path;
            }
            return this.getClass().getClassLoader().getResourceAsStream(path);
        }
    }
    @Override
    public OutputStream create(String path) throws IOException {
        if (path.contains(SEPARATE)) {
            path = path.substring(path.indexOf("/") + 1);
        }
        File file = new File("src/main/resources/dictionary/cache");
        if (!file.exists()){
            file.mkdirs();
        }
        return new FileOutputStream("src/main/resources/dictionary/cache/" + path);
    }
}
