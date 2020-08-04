package com.vankeytech.vocabulary.business;

import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liuheng
 * @date 2020/8/3 14:37
 */
public class Participle {

    @Resource
    private Segment segment;

    /**
     * 获取分词后词语出现的次数(默认使用停止词库,过滤单字)
     * @param statement 待分词文本
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public Map<String,Integer> wordFrequency(String statement){
        return  wordFrequency(statement,2,true);
    }

    /**
     * 获取分词后词语出现的次数(默认使用停止词库)
     * @param statement 待分词文本
     * @param filterLength 过滤低于指定字符结果
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public Map<String,Integer> wordFrequency(String statement,Integer filterLength){
        return  wordFrequency(statement,filterLength,true);
    }

    /**
     * 排序
     * 获取分词后词语出现的次数(默认使用停止词库)
     * @param statement 待分词文本
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public List<Map.Entry<String, Integer>> wordFrequencySort(String statement){
        Map<String, Integer> map = wordFrequency(statement, 2, true);
        List<Map.Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
        Collections.sort(result, (o1, o2) -> o2.getValue() - o1.getValue());
        return result;
    }
    /**
     * 排序
     * 获取分词后词语出现的次数(默认使用停止词库)
     * @param statement 待分词文本
     * @param filterLength 过滤低于指定字符结果
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public List<Map.Entry<String, Integer>> wordFrequencySort(String statement, Integer filterLength){
        Map<String, Integer> map = wordFrequency(statement, filterLength, true);
        List<Map.Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
        Collections.sort(result, (o1, o2) -> o2.getValue() - o1.getValue());
        return result;
    }
    /**
     * 排序
     * 获取分词后词语出现的次数(默认使用停止词库)
     * @param statement 待分词文本
     * @param filterLength 过滤低于指定字符结果
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public List<Map.Entry<String, Integer>> wordFrequencySort(String statement, Integer filterLength, Boolean usingStop){
        Map<String, Integer> map = wordFrequency(statement, filterLength, usingStop);
        List<Map.Entry<String, Integer>> result = new ArrayList<>(map.entrySet());
        Collections.sort(result, (o1, o2) -> o2.getValue() - o1.getValue());
        return result;
    }

    /**
     * 获取分词后词语出现的次数
     * @param statement 待分词文本
     * @param filterLength 过滤低于指定字符结果
     * @param usingStop 是否使用停止词库
     * @return 一个Map KEY是单词 VALUE是出现次数
     */
    public Map<String,Integer> wordFrequency(String statement, Integer filterLength, Boolean usingStop){
        HashMap<String, Integer> map = new HashMap<>();
        List<Term> terms = segment.seg(statement);
        if (usingStop) {
            CoreStopWordDictionary.apply(terms);
        }
        for (Term term : terms) {
            if (term.word.length() >= filterLength) {
                Integer integer = map.get(term.word);
                if (integer == null) {
                    map.put(term.word, 1);
                } else {
                    map.put(term.word, ++integer);
                }
            }
        }
        return map;
    }
}
