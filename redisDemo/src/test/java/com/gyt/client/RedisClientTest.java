/**
 * FileName: redisClientTest
 * Author:   Rock_Guo
 * Date:     2018/7/4 14:51
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.gyt.client;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Rock_Guo
 * @create 2018/7/4
 * @since 1.0.0
 */
public class RedisClientTest {

    @Test
    public void redisTest(){

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("连接成功！");
        jedis.auth("Rock1987guo");
        System.out.println("服务正在运行："+jedis.ping());

        // 设置字符串
        jedis.set("address", "北京市海淀区");
        System.out.println("address = "+jedis.get("address"));

        // 设置列表 List
        jedis.del("students");
        jedis.lpush("students", "ZhangSan");
        jedis.lpush("students", "LiSi", "WangWu", "Zhaoliu");
        jedis.rpush("students", "GuiJiaoqi");
        System.out.println("students.length = "+jedis.llen("students"));
        List<String> list = jedis.lrange("students", 0, jedis.llen("students"));
        for(int i=0; i<list.size(); i++){
            System.out.println("list("+i+") = "+list.get(i));
        }

        // 所有key
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }

        jedis.close();

    }
}
