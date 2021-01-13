package Sort;

/*
* 选择排序
* 首先在未排序序列中找到最小元素
* 和未排序的第一个元素交换
* 在剩下的未排序序列中选择次小元素，交换
* */

public class SelectionSort {
    public static int[] selectSort(int [] array){
        if(array.length == 0){
            return array;
        }
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            int min = i;
            for(int j = i+1; j < n; j++){
                if(array[j] < array[min]){
                    min = j; // 找出最小元素的下标
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }
}
