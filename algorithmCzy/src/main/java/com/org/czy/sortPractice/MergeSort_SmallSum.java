package main.java.com.org.czy.sortPractice;

/**
 * 归并排序
 * 求一个数组的小和
 * 当前位置数值减去前面所有比自己小的数的差的和即为该位置的小和，所有位置小和加起来即为整个数组的小和
 * 数组[1,3,4,2,5]，1没有，3为3-1,4为4-1+4-3,2为2-1,5为5-1+5-3+5-4+5-2，即1+1+3+1+1+3+4+2=16
 */
public class MergeSort_SmallSum {

    public static int mergeSort(int[] arr){
        if(arr == null || arr .length < 2){
            return 0;
        }
        return mergeProcess(arr, 0, arr.length-1);
    }

    public static int mergeProcess(int[] arr, int start, int end){
        if(start == end){
            return 0;
        }
        int mid =start + ((end - start) >> 1);//等价(start+end)/2,但这样可能会溢出
        return mergeProcess(arr, start, mid) + mergeProcess(arr, mid+1, end) + merge(arr, start, mid, end);
    }

    public static int merge(int[] arr, int start, int mid, int end){

        int i = start;
        int j = mid + 1;
        int index = 0;
        int[] help = new int[end - start + 1];
        int result = 0;
        while(i<=mid && j<= end){
            result += arr[i] < arr[j] ? arr[i]*(end - j + 1) : 0;
            help[index++] = arr[i]<arr[j] ? arr[i++] : arr[j++];
        }
        //此处已经可以返回结果，但是还是把归并排序做完
        while(i<=mid){
            help[index++] = arr[i++];
        }
        while(j<= end){
            help[index++] = arr[j++];
        }
        for(i =0; i < help.length; i++){
            arr[start+i] = help[i];
        }
        return result;
    }

    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (mergeSort(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
