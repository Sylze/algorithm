package sort;

/**
 * Created by SZ on 2017/8/21.
 */
public class QuickSort {
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if(left >= right) return;
//        int pivot = partition(a, left, right), i = left + 1, j = right - 1;
        int pivot = a[right], i = left, j = right;
        while (i < j) {
            while (a[i] < pivot) i++;
            while (a[j] > pivot) j--;
            if(i < j) swap(a, i, j);
        }
        quickSort(a, left, i - 1);
        quickSort(a, i + 1, right);
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static int partition(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        if(a[mid] < a[left])
            swap(a, left, mid);
        if(a[right] < a[left])
            swap(a, left, right);
        if(a[right] < a[mid])
            swap(a, mid, right);
        swap(a, mid, right - 1);
        return a[right - 1];
    }

    public static void main(String[] args) {
        int[] a = {2,1,3,5,6,4,9,7,8};
//        int[] a = {1,2,3,4,5,6,7,8,9};
        quickSort(a);
        for (int num: a) {
            System.out.print(num);
        }
        System.out.println();
    }
}
