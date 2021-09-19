import java.util.Arrays;

/**
 * @author yuanyibo
 * @create 2021/09/18 21:56
 */
public class InsertSort {

    public static void main(String[] args) {
        InsertSort app = new InsertSort();
        int[] a={10,3,2,7,8,9,6,1,0};
        app.insertSort(a, 0, a.length-1);
        Arrays.stream(a).forEach(System.out::print);
    }

    public void insertSort(int[] a, int l, int r){
        if(l>=r){
            return;
        }
        for(int i=l+1;i<=r;i++){
            int temp = a[i];
            int j = i;
            // 从无序区向有序区移动
            while (j-1>=l && temp<a[j-1]){
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
    }

}
