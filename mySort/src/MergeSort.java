import java.util.Arrays;

/**
 * @author yuanyibo
 * @create 2021/09/17 21:19
 */
public class MergeSort {
    public static void main(String[] args) {
        MergeSort app = new MergeSort();
        int[] a={10,3,2,7,8,9,6,1,0};
        app.mergeSort(a, 0, a.length-1);
        Arrays.stream(a).forEach(System.out::print);
    }

    public void mergeSort(int[] a, int left, int right){
        if(left<right){
            // 1.分
            int mid = left + (right - left) / 2;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            // 2.合
            merge(a, left, mid, right);
        }
    }

    public void merge(int[] a, int left, int mid, int right){
        int[] b = new int[right-left+1];
        int i=left,j=mid+1,k=0;
        while (i<=mid && j<=right){
            if(a[i]<a[j]){
                b[k++] = a[i];
                i++;
            } else {
                b[k++] = a[j];
                j++;
            }
        }
        while (i<=mid){
            b[k++] = a[i++];
        }
        while (j<=right){
            b[k++] = a[j++];
        }
        // 把新数组中的数覆盖a数组
        for (int k2 = 0; k2 < b.length; k2++) {
            a[k2 + left] = b[k2];
        }
    }

}
