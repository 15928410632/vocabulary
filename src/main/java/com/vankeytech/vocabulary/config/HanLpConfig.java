package com.vankeytech.vocabulary.config;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.corpus.io.IIOAdapter;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.vankeytech.vocabulary.business.Participle;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

import java.util.List;

import static com.hankcs.hanlp.HanLP.newSegment;

/**
 * @author liuheng
 * @date 2020/7/31 9:56
 */
@EnableConfigurationProperties(value = {HanLpProperties.class,SegmentProperties.class})
public class HanLpConfig {

    private static final Logger log = LoggerFactory.getLogger(HanLpConfig.class);

    @Resource
    private SegmentProperties segmentProperties;

    @Bean(name = "segment")
    public Segment segment(){
        CustomDictionary.reload();
        Segment segment = newSegment();
        segmentConfig(segment);
        List<Term> hanLP = segment.seg("欢迎使用HanLP");
        log.info(hanLP.toString());
        return segment;
    }

    private void segmentConfig(Segment segment) {
        Integer indexMode = segmentProperties.getIndexMode();
        if (indexMode!=null) {
            segment.enableIndexMode(indexMode);
        }
        Boolean nameRecognize = segmentProperties.getNameRecognize();
        if (nameRecognize!=null) {
            segment.enableNameRecognize(nameRecognize);
        }
        Boolean recognize = segmentProperties.getTranslatedNameRecognize();
        if (recognize!=null){
            segment.enableTranslatedNameRecognize(recognize);
        }
        Boolean japaneseNameRecognize = segmentProperties.getJapaneseNameRecognize();
        if (japaneseNameRecognize!=null){
            segment.enableJapaneseNameRecognize(japaneseNameRecognize);
        }
        Boolean placeRecognize = segmentProperties.getPlaceRecognize();
        if (placeRecognize!=null){
            segment.enableTranslatedNameRecognize(placeRecognize);
        }
        Boolean organizationRecognize = segmentProperties.getOrganizationRecognize();
        if (organizationRecognize!=null){
            segment.enableOrganizationRecognize(organizationRecognize);
        }
        Boolean useCustomDictionary = segmentProperties.getUseCustomDictionary();
        if (useCustomDictionary!=null){
            segment.enableCustomDictionary(useCustomDictionary);
        }
        Boolean forceCustomDictionary = segmentProperties.getForceCustomDictionary();
        if (forceCustomDictionary!=null){
            segment.enableCustomDictionaryForcing(forceCustomDictionary);
        }
        Boolean speechTagging = segmentProperties.getSpeechTagging();
        if (speechTagging!=null){
            segment.enablePartOfSpeechTagging(speechTagging);
        }
        Boolean offset = segmentProperties.getOffset();
        if (offset!=null){
            segment.enableOffset(offset);
        }
        Boolean numberQuantifierRecognize = segmentProperties.getNumberQuantifierRecognize();
        if (numberQuantifierRecognize!=null){
            segment.enableNumberQuantifierRecognize(numberQuantifierRecognize);
        }
        Integer threadNumber = segmentProperties.getThreadNumber();
        if (threadNumber!=null){
            segment.enableMultithreading(threadNumber);
        }
    }
}
