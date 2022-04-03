package com.xiangjun.code1;

/**
 * 选择排序算法，
 * 时间复杂度 O(N^2)
 * 空间复杂度 O(1)
 */
public class SelectSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3,5,6,8,1,4,6,432,34,9,0,22,8};
        selectSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void selectSort(int[] arr) {
        if(arr.length == 0 || arr.length < 2){
            return ;
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < temp){
                    temp = arr[j];
                    swap(arr,i,j);
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
