package com.xiangjun.code1;

/**
 * 异或运算法则
 * 1、0^0=0,1^0=1,0^1=1,1^1=0。可以理解为无进位相加。就是位相加不算进位。
 * 2、0^N=N,N^N=0
 * 3、异或满足交换律和结合律。故一堆数字同时异或的话与异或的顺序无关，无论谁先异或谁后异或，最终的答案始终是一个。
 * 4、结合2和3可以得出，奇数值个项异或为这个数本身，偶数值个项异或为0
 * 5、结合2可以得出，可以通过异或交换两个数的值，但是这个是一种取巧的方式，这两个数的内存空间不能一样。否则会被抹成0，项目慎用
 *
 * 经典面试题
 * 1、一堆数中，有一种数的个数是奇数，其余数的个数都是偶数，求得这个数的值是多少？
 * 2、一堆数中，有二种数的个数是奇数，其余数的个数都是偶数，求得这个两个数的值是多少？
 *
 * 可以通过异或运算法则求解
 */
public class ExclusiveOR {

    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,1,2,2,6,6,8,9,9,8,8};
        int arr1[] = new int[]{1,1,1,1,2,2,6,6,8,9,9,8,8,9};
        oneNum(arr);
        twoNum(arr1);
    }

    /**
     * 一堆数中，有一种数的个数是奇数，其余数的个数都是偶数，求得这个数的值是多少？
     * 将这对数中的每个数都拿来异或一边，由于推理4可以得出，最终异或出来的值就是这个奇数值
     */
    public static int oneNum(int[] arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }
        System.out.println(eor);
        return eor;
    }

    /**
     * 一堆数中，有二种数的个数是奇数，其余数的个数都是偶数，求得这个两个数的值是多少？
     *
     * 可以利用推理4
     */
    public static void twoNum(int[] arr){
        int eor = 0;
        for (int i : arr) {
            eor ^= i;
        }

        /**
         * 假如 这两个数为a,b，那么上面的结果是 a^b
         * 这个时候想要获取这两个数的值，那么需要想办法将两个数区分开来，在异或。
         * 如何区分开来？  这个时候需要从字节位上面考虑，因为是两个数，那么这两个数肯定不相同，
         * 那么在位上面来看，肯定两个数在某一位上，不相同，即有一个数在某一位是0，有一个数在某一位是0。
         * 想办法找出这个位就可以区分这两个数了。
         * 这个时候会想到提取出某一个数的最右边一位1，会获得一个数，这个数可以区分。
         */

        int s = eor & (~eor + 1); //这一行代码就可以提取出a,b不相同的最右边的一位1所在的位.

        int onlyEor = 0;
        for (int a : arr) {
            if((s & a) == s){//这一行代码表示，如果是a或者b就纳入异或，最终只会异或其中的某一项。
                onlyEor ^= a;
            }
        }

        //得到另外一项
        int other = eor ^ onlyEor;
        System.out.println(onlyEor + "," + other);
    }
}
