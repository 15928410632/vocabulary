package com.vankeytech.vocabulary.adapter;

import com.hankcs.hanlp.corpus.io.IIOAdapter;

import java.io.*;
import java.net.URL;

/**
 * 文件读取处理器
 *
 * @author liuheng
 * @date 2020/7/31 14:20
 */
public class ResourceFileIOAdapter implements IIOAdapter {
    @Override
    public InputStream open(String path) throws IOException {
        boolean isCache = path.endsWith("bin");
        if (path.contains("/")){
            path = path.substring(path.indexOf("/")+1);
        }
        if (isCache) {
            path = "dictionary/cache/" + path;
        }else {
            path = "dictionary/"+path;
        }
        return this.getClass().getClassLoader().getResourceAsStream(path);
    }
    @Override
    public OutputStream create(String path) throws IOException {
        return new FileOutputStream("src/main/resources/dictionary/cache/" + path);
    }
}
