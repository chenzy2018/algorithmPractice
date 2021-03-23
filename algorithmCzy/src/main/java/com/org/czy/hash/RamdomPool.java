package main.java.com.org.czy.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计RandomPool结构
 * 【题目】 设计一种结构，在该结构中有如下三个功能：
 * insert(key)：将某个key加入到该结构，做到不重复加入。
 * delete(key)：将原本在结构中的某个key移除。 getRandom()：
 * 等概率随机返回结构中的任何一个key。
 * 【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
 */

public class RamdomPool {

    public static class RamdonpoolTest {
        public Map<String, Integer> map1;
        public Map<Integer, String> map2;
        public int size;

        public RamdonpoolTest() {
            map1 = new HashMap<>();
            map2 = new HashMap<>();
            size = 0;
        }

        public void insert(String str) {
            if (!map1.containsKey(str)) {
                map1.put(str, size);
                map2.put(size++, str);
            }
        }

        /**
         * 避免中间有空，所以用最后一个补上要删除的位置
         */
        public void delete(String str) {
            if (map1.containsKey(str)) {
                int deleteIndex = map1.get(str);
                int lastIndex = --size;
                String lastStr = map2.get(lastIndex);
                map1.put(lastStr, deleteIndex);
                map2.put(deleteIndex, lastStr);
                map1.remove(lastStr);
                map2.remove(lastIndex);
            }

        }

        public String getRandom() {
            if (size == 0) return null;

            int index = (int) (Math.random() * size);// 0 - size-1
            return map2.get(index);
        }
    }

    public static void main(String[] args) {
        RamdonpoolTest pool = new RamdonpoolTest();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
