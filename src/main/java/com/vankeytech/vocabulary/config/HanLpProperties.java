package com.vankeytech.vocabulary.config;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IIOAdapter;
import com.hankcs.hanlp.utility.TextUtility;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.lang.reflect.Constructor;

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

    public void setCoreDictionaryPath(String coreDictionaryPath) {
        HanLP.Config.CoreDictionaryPath = coreDictionaryPath;
    }

    public void setBiGramDictionaryPath(String biGramDictionaryPath) {
        HanLP.Config.BiGramDictionaryPath = biGramDictionaryPath;
    }

    public void setCustomDictionaryPath(String[] customDictionaryPath) {
        HanLP.Config.CustomDictionaryPath = customDictionaryPath;
    }

    public void setCoreStopWordDictionaryPath(String coreStopWordDictionaryPath) {
        HanLP.Config.CoreStopWordDictionaryPath = coreStopWordDictionaryPath;
    }

    public void setCoreSynonymDictionaryDictionaryPath(String coreSynonymDictionaryDictionaryPath) {
        HanLP.Config.CoreSynonymDictionaryDictionaryPath = coreSynonymDictionaryDictionaryPath;
    }

    public void setPersonDictionaryPath(String personDictionaryPath) {
        HanLP.Config.PersonDictionaryPath = personDictionaryPath;
    }

    public void setPersonDictionaryTrPath(String personDictionaryTrPath) {
        HanLP.Config.PersonDictionaryTrPath = personDictionaryTrPath;
    }

    public void setTcDictionaryRoot(String tcDictionaryRoot) {
        HanLP.Config.tcDictionaryRoot = tcDictionaryRoot;
    }

    public void setCharTypePath(String charTypePath) {
        HanLP.Config.CharTypePath = charTypePath;
    }

    public void setCharTablePath(String charTablePath) {
        HanLP.Config.CharTablePath = charTablePath;
    }

    public void setIoAdapter(String ioAdapter) {
        if (ioAdapter != null)
        {
            try
            {
                Class<?> clazz = Class.forName(ioAdapter);
                Constructor<?> ctor = clazz.getConstructor();
                Object instance = ctor.newInstance();
                HanLP.Config.IOAdapter = (IIOAdapter) instance;
            }
            catch (ClassNotFoundException e)
            {
                logger.warning(String.format("找不到IO适配器类： %s ，请检查第三方插件jar包", ioAdapter));
            }
            catch (NoSuchMethodException e)
            {
                logger.warning(String.format("工厂类[%s]没有默认构造方法，不符合要求", ioAdapter));
            }
            catch (SecurityException e)
            {
                logger.warning(String.format("工厂类[%s]默认构造方法无法访问，不符合要求", ioAdapter));
            }
            catch (Exception e)
            {
                logger.warning(String.format("工厂类[%s]构造失败：%s\n", ioAdapter, TextUtility.exceptionToString(e)));
            }
        }
    }

}
