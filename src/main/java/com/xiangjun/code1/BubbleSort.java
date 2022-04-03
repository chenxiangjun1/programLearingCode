package com.xiangjun.code1;

/**
 * 冒泡排序算法
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 * 感悟：该冒泡排序中，第一层循环表示的循环的范围，第二重循环才是循环的具体指标。
 */
public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3,5,6,8,1,4,6,432,34,9,0,22,8};
        bubbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void bubbleSort(int[] arr) {
        if(arr.length == 0 || arr.length < 2){
            return ;
        }

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
