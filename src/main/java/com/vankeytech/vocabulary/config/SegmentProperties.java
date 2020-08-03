package com.vankeytech.vocabulary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liuheng
 * @date 2020/8/3 17:30
 */
@ConfigurationProperties(prefix = "han-lp.segment")
public class SegmentProperties {
    /**
     * 是否是索引分词（合理地最小分割），indexMode代表全切分词语的最小长度（包含）
     */
    private Integer indexMode;
    /**
     * 是否识别中国人名
     */
    private Boolean nameRecognize;
    /**
     * 是否识别音译人名
     */
    private Boolean translatedNameRecognize;
    /**
     * 是否识别日本人名
     */
    private Boolean japaneseNameRecognize;
    /**
     * 是否识别地名
     */
    private Boolean placeRecognize;
    /**
     * 是否识别机构
     */
    private Boolean organizationRecognize;
    /**
     * 是否加载用户词典
     */
    private Boolean useCustomDictionary;
    /**
     * 用户词典高优先级
     */
    private Boolean forceCustomDictionary;
    /**
     * 词性标注
     */
    private Boolean speechTagging;
    /**
     * 是否计算偏移量
     */
    private Boolean offset;
    /**
     * 是否识别数字和量词
     */
    private Boolean numberQuantifierRecognize;
    /**
     * 并行分词的线程数
     */
    private Integer threadNumber;

    public Integer getIndexMode() {
        return indexMode;
    }

    public void setIndexMode(Integer indexMode) {
        this.indexMode = indexMode;
    }

    public Boolean getNameRecognize() {
        return nameRecognize;
    }

    public void setNameRecognize(Boolean nameRecognize) {
        this.nameRecognize = nameRecognize;
    }

    public Boolean getTranslatedNameRecognize() {
        return translatedNameRecognize;
    }

    public void setTranslatedNameRecognize(Boolean translatedNameRecognize) {
        this.translatedNameRecognize = translatedNameRecognize;
    }

    public Boolean getJapaneseNameRecognize() {
        return japaneseNameRecognize;
    }

    public void setJapaneseNameRecognize(Boolean japaneseNameRecognize) {
        this.japaneseNameRecognize = japaneseNameRecognize;
    }

    public Boolean getPlaceRecognize() {
        return placeRecognize;
    }

    public void setPlaceRecognize(Boolean placeRecognize) {
        this.placeRecognize = placeRecognize;
    }

    public Boolean getOrganizationRecognize() {
        return organizationRecognize;
    }

    public void setOrganizationRecognize(Boolean organizationRecognize) {
        this.organizationRecognize = organizationRecognize;
    }

    public Boolean getUseCustomDictionary() {
        return useCustomDictionary;
    }

    public void setUseCustomDictionary(Boolean useCustomDictionary) {
        this.useCustomDictionary = useCustomDictionary;
    }

    public Boolean getForceCustomDictionary() {
        return forceCustomDictionary;
    }

    public void setForceCustomDictionary(Boolean forceCustomDictionary) {
        this.forceCustomDictionary = forceCustomDictionary;
    }

    public Boolean getSpeechTagging() {
        return speechTagging;
    }

    public void setSpeechTagging(Boolean speechTagging) {
        this.speechTagging = speechTagging;
    }

    public Boolean getOffset() {
        return offset;
    }

    public void setOffset(Boolean offset) {
        this.offset = offset;
    }

    public Boolean getNumberQuantifierRecognize() {
        return numberQuantifierRecognize;
    }

    public void setNumberQuantifierRecognize(Boolean numberQuantifierRecognize) {
        this.numberQuantifierRecognize = numberQuantifierRecognize;
    }

    public Integer getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(Integer threadNumber) {
        this.threadNumber = threadNumber;
    }
}
