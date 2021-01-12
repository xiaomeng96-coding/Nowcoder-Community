package Sort;

/*
* 冒泡排序
* 比较相邻的两元素，如果第一个大于第二个，交换
* 相邻元素两两交换，直到最大的一个在最后
* 重复直到排序完成，时间复杂度O(n*n)
* */

public class BubbleSort {
    public static int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }
        int n = array.length;
        for (int i = n-1; i >0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]){ // 交换相邻的两个数
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
