package com.vankeytech.vocabulary;

import com.vankeytech.vocabulary.business.Participle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class VocabularyApplicationTests {

    @Resource
    private Participle participle;

    @Test
    void contextLoads() {
        String text = "我想这个Redis之父肯定没想到，自己和小伙伴启动的项目，在10年后的今天，会对这个互联网时代产生这么大的影响吧，说Redis加速了互联网公司的发展也不为过。\n" +
                "\n" +
                "其实很多开源项目都是作者一个无意间的初衷启动的，然后不经意间做到了各个领域的世界第一，比如Linux，Nginx等等，都是小小的体积蕴含着大大的能量。\n" +
                "\n" +
                "我之前所在的团队是做电商活动的，可以说Redis就是我接触最多的中间件，所以我文章最开始也是以Redis作为系列的开篇，对它的感情也可以说比正常程序员都要独特，他的各种使用场景，高级用法我几乎接触了一个遍，在很长一段时间也成为我面试的杀手锏，我研读过Redis很多功能的源码，不得不说这个团队真的把性能的优化做到了极致，用最短的代码，做到了最大的性能优化。\n" +
                "\n" +
                "如果不是技术的同学可能不是很明白，这么说吧，大家进任何网页第一眼能看到的东西，大部分都是跟缓存息息相关的，或者也是利用了缓存这样的概念，一旦缓存挂了，那所有的网站可能会天天都会发生微博宕机那样的事故，所有人都无法正常访问网站，大量的流量会瞬间击垮服务器。\n" +
                "\n" +
                "在Redis中，数据结构这个词的意义不仅表示在某种数据结构上的操作，更包括了结构本身及这些操作的时间空间复杂度。\n" +
                "\n" +
                "Redis 定位是一个内存数据库，正是由于内存的快速访问特性，才使得Redis能够有如此高的性能，才使得Redis能够轻松处理大量复杂的数据结构，Redis会尝试其它的存储方面的选择，但是永远不会改变它是一个内存数据库的角色。\n" +
                "\n" +
                "Redis 有着诗一般优美的代码，经常有一些不太了解Redis 原则的人会建议Redis采用一些其它人的代码，以实现一些Redis 未实现的功能，但这对研发团队来说来说就像是非要给《红楼梦》接上后四十回一样。\n" +
                "\n" +
                "Redis的深度用户都知道，缓存只是他最简单和基础的功能罢了，哨兵，集群，分布式锁，延时队列，位图，HyperLogLog，布隆过滤器，限流，GeoHash（附近的人）等等，眼花缭乱的类型和使用姿势多得不行。\n" +
                "\n" +
                "这里面大部分的东西在antirez维护Redis的早期就诞生了，是不是对他的敬佩又多了一分。\n" +
                "\n" +
                "antirez这样的大神能坚持这么多年，我想枯燥是必然的，但是如果你跟我一样关注他的Twitter你会发现，这个人是真的热爱这项事业。";
        List<Map.Entry<String, Integer>> entries = participle.wordFrequencySort(text);
        System.out.println(entries);
    }
}
