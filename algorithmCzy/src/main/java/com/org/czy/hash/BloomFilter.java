package main.java.com.org.czy.hash;

/**
 * 布隆过滤器
 *  存在一定失误率，hash函数越多，失误率就越多
 *
 *  bit数组开多大
 *      m = （n*lnp）/((ln2)^2) (ln:自然对数，n：样本量(下面的100亿)，p：失误率)
 *
 *  hash函数个数K
 *      k = ln2 * （m/n）
 *
 * 实现100亿个黑名单的过滤：
 *  把黑名单中的每个URL经过K个相互独立的hash函数，然后会把位图上至多K个位置变成1，这样才算是URL进到了Bloom中
 *
 *  需要校验的URL来了，经过上面K个hash函数之后的结果，如果结果对应Bloom中每个位置都是1，就是黑名单里的URL，如果有一个不是，就认为不是
 */
public class BloomFilter {

    int[] bloom = new int[1000]; //4*8*1000bit，也可以用long，也可以用二维的数组

    //在位图中标记num的位置为1
    public void addBit(int num){
        int intValue = num / 32;//定位是第几个int
        int bitValue = num % 32;//定位是int的第几个bit
        bloom[intValue] = (bloom[intValue] | (1 << bitValue));//把位图中的对应bit位变成1
    }
}
