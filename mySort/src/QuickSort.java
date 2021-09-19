import java.util.Arrays;

/**
 * @author yuanyibo
 * @create 2021/09/17 21:06
 */
public class QuickSort {

    public static void main(String[] args) {
        QuickSort app = new QuickSort();
        int[] a={10,3,2,7,8,9,6,1,0};
        app.quickSort(a, 0, a.length-1);
        Arrays.stream(a).forEach(System.out::print);
    }

    public int[] quickSort(int[] a, int p, int r){
        if(p<r){
            // partition将a分为[p, q-1],[q],[q+1, r]三段
            int q = partition(a, p, r);
            quickSort(a, p, q-1);
            quickSort(a, q+1, r);
        }
        return a;
    }

    public int partition(int[] a, int p, int r){
        int left = p + 1;
        int right = r;
        int x = a[p];
        while (true){
            // 从p+1开始右移左指针，直到找到某个大于a[p]的数，等待交换
            while (a[left]<x){
                left++;
                if(left==a.length){
                    break;
                }
            }
            // 从最右端左移右指针，直到找到某个小于a[p]的数
            while (a[right]>x){
                right--;
                if(right==0){
                    break;
                }
            }
            if(left>=right){
                break;
            }
            int temp = a[left];
            a[left] = a[right];
            a[right] = temp;
        }
        // 这里只能用right，因为有可能left>right，即left==a.length的情况
        a[p] = a[right];
        a[right] = x;
        return right;
    }

}
