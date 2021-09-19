package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author yuanyibo
 * @create 2021/09/17 20:24
 */
public class 快速排序 {


    public static void main(String[] args) {
        快速排序 app = new 快速排序();
        int[] a={10,3,2,7,8,9,6,1,0};
        app.sort(a, 0, a.length-1);
    }

    public int[] sort(int[] a, int p, int r){
        if(p<r){
            int q = partition(a, p, r);
            sort(a, p, q-1);
            sort(a, q+1, r);
        }
        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
        return a;
    }

    public int partition(int[] a, int p, int r){
        int i=p, j = r+1;
        int x = a[p];
        while (true){
            while (a[++i]<x){
                if(i==a.length-1){
                    break;
                }
            };
            while (a[--j]>x){
                if(j==0){
                    break;
                }
            };
            if(i>=j){
                break;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[p] = a[j];
        a[j] = x;
        return j;
    }

}
