package com.vankeytech.vocabulary.config;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IIOAdapter;
import com.hankcs.hanlp.utility.TextUtility;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hankcs.hanlp.utility.Predefine.logger;

/**
 * @author liuheng
 * @date 2020/7/31 13:35
 */
@ConfigurationProperties(prefix = "han-lp")
public class HanLpProperties {
    /**
     * 核心词典路径
     */
    private String coreDictionaryPath;
    /**
     * 2元语法词典路径
     */
    private String biGramDictionaryPath;
    /**
     * 自定义词典路径
     */
    private String[] customDictionaryPath;
    /**
     * 停用词词典路径
     */
    private String coreStopWordDictionaryPath;
    /**
     * 同义词词典路径
     */
    private String coreSynonymDictionaryDictionaryPath;
    /**
     * 人名词典路径
     */
    private String personDictionaryPath;
    /**
     * 人名词典转移矩阵路径
     */
    private String personDictionaryTrPath;
    /**
     * 繁简词典根目录
     */
    private String tcDictionaryRoot;
    /**
     * 字符类型对应表
     */
    private String charTypePath;
    /**
     * 字符正规化表（全角转半角，繁体转简体）
     */
    private String charTablePath;
    /**
     * IO适配器
     */
    private String ioAdapter;

    public String getCoreDictionaryPath() {
        return coreDictionaryPath;
    }

    public String getBiGramDictionaryPath() {
        return biGramDictionaryPath;
    }

    public String[] getCustomDictionaryPath() {
        return customDictionaryPath;
    }

    public String getCoreStopWordDictionaryPath() {
        return coreStopWordDictionaryPath;
    }

    public String getCoreSynonymDictionaryDictionaryPath() {
        return coreSynonymDictionaryDictionaryPath;
    }

    public String getPersonDictionaryPath() {
        return personDictionaryPath;
    }

    public String getPersonDictionaryTrPath() {
        return personDictionaryTrPath;
    }

    public String getTcDictionaryRoot() {
        return tcDictionaryRoot;
    }

    public String getCharTypePath() {
        return charTypePath;
    }

    public String getCharTablePath() {
        return charTablePath;
    }

    public String getIoAdapter() {
        return ioAdapter;
    }

    public void setCoreDictionaryPath(String coreDictionaryPath) {
       this.coreDictionaryPath = "customize:"+coreDictionaryPath;
    }

    public void setBiGramDictionaryPath(String biGramDictionaryPath) {
       this.biGramDictionaryPath = "customize:"+biGramDictionaryPath;
    }

    public void setCustomDictionaryPath(String[] customDictionaryPath) {
        List<String> strings = new ArrayList<>(Arrays.asList(HanLP.Config.CustomDictionaryPath));
        for (String path : customDictionaryPath) {
            strings.add("customize:"+path);
        }
        this.customDictionaryPath = strings.toArray(new String[strings.size()]);
    }

    public void setCoreStopWordDictionaryPath(String coreStopWordDictionaryPath) {
        this.coreStopWordDictionaryPath = "customize:"+coreStopWordDictionaryPath;
    }

    public void setCoreSynonymDictionaryDictionaryPath(String coreSynonymDictionaryDictionaryPath) {
        this.coreSynonymDictionaryDictionaryPath = "customize:"+coreSynonymDictionaryDictionaryPath;
    }

    public void setPersonDictionaryPath(String personDictionaryPath) {
        this.personDictionaryPath = "customize:"+personDictionaryPath;
    }

    public void setPersonDictionaryTrPath(String personDictionaryTrPath) {
        this.personDictionaryTrPath = "customize:"+personDictionaryTrPath;
    }

    public void setTcDictionaryRoot(String tcDictionaryRoot) {
       this.tcDictionaryRoot = "customize:"+tcDictionaryRoot;
    }

    public void setCharTypePath(String charTypePath) {
        this.charTypePath = "customize:"+charTypePath;
    }

    public void setCharTablePath(String charTablePath) {
        this.charTablePath = "customize:"+charTablePath;
    }

    public void setIoAdapter(String ioAdapter) {
        this.ioAdapter = ioAdapter;
    }

}
