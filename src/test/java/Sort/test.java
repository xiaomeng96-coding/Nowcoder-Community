package Sort;

public class test {
    public static void main(String[] args) {
        int []a = {10,20,1,0,5,89,71,20,34,56,17,3};
        BubbleSort.bubbleSort(a);  // 冒泡排序
        show(a);

        int []b = {10,20,1,0,5,89,71,20,34,56,17,3};
        SelectionSort.selectSort(b); // 选择排序
        show(b);
    }

    // 封装打印方法
    public static void show(int []array){
        for(int i: array){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
