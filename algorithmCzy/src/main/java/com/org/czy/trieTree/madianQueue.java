package main.java.com.org.czy.trieTree;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 一个数据流中，随时可以取得中位数
 */
public class madianQueue {

    public static class MedianHolder{

        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> {
            if(o1 > o2){
                return 1;
            }else{
                return -1;
            }
        });

        public void addNumber(int num){
            if(maxHeap.isEmpty()){
                maxHeap.add(num);
                return;
            }

            if(maxHeap.peek() >= num){
                maxHeap.add(num);
            }else{
                if(minHeap.isEmpty()){
                    minHeap.add(num);
                    return;
                }
                if(minHeap.peek() > num){
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }
            }
            modifySize();
        }

        public void modifySize(){
            if(maxHeap.size() == minHeap.size() + 2) minHeap.add(maxHeap.poll());
            if(minHeap.size() == maxHeap.size() + 2) maxHeap.add(minHeap.poll());
        }

        public int getMedian(){
            int maxSize = maxHeap.size();
            int minSize = minHeap.size();
            if(maxSize+minSize == 0) return 0;

            Integer maxpeek = maxHeap.peek();
            Integer minPeek = minHeap.peek();
            if(((maxSize+minSize) & 1) == 0) return (maxpeek+minPeek) / 2;
            return maxSize > minSize ? maxpeek: minPeek;
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
