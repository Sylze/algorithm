package sort;

/**
 * Created by SZ on 2017/8/21.
 */
public class HeapSort {

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static void precDown(int[] a, int i, int len) {
        int child;
        int tmp;
        for(tmp = a[i]; leftChild(i) < len; i = child) {
            child = leftChild(i);
            if(child != len - 1 && a[child] < a[child + 1]) {
                child++;
            }
            if(a[i] < a[child]) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = tmp;
    }


    public static void heapSort(int[] a) {
        /* build heap */
        for(int i = a.length / 2; i >= 0; i--) {
            precDown(a, i, a.length);
        }
        /* delete max */
        for(int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            precDown(a, 0 , i);
        }
    }



    public static void main(String[] args) {
        int[] a = {2,1,3,5,6,4,9,7,8};
        heapSort(a);
        for (int num: a) {
            System.out.print(num);
        }
        System.out.println();
    }
}
