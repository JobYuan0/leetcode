package common;

/**
 *
 * https://zhuanlan.zhihu.com/p/304745110
 * @author yuanyibo
 * @create 2021/09/18 21:35
 */

public class 求中位数 {

    static int scope =5;
    public static void main(String[] args) {

        int[] arr = new int[]{5,6,8,7,3,2,1,4,10,20,39,12,21,19,27,23,25,6,7};

        bfptrSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int[] bfptrSort(int[] arr){
        return bfptrSort(arr,0,arr.length-1);
    }

    public static int[] bfptrSort(int[] arr,int s,int e){
        if(s<e){
            int king = findKing(arr,s,e);
            int p = partition(arr,s,e,king);
            bfptrSort(arr,s,p-1);
            bfptrSort(arr,p+1,e);
        }
        return arr;
    }


    public static int findKing(int[] arr,int s,int e){
        int[] medias = findMedias(arr,s,e);
        insertSort(medias,0,medias.length-1);
        int king = medias[(medias.length-1) >> 1];
        return king;
    }


    /***
     * 对{arr[e]~arr[s]}这一段分组求中为数
     * @param arr
     * @param s start
     * @param e end
     * @return
     */
    public static int[] findMedias(int[] arr,int s,int e){
        //通过给定的start和end，先定义好有几个中位数
        int[] res = new int[(int)Math.ceil((e-s+1.0)/scope)];
        int k=0;

        //如果e-s<scope说明可以直接对arr的s~e这一段进行快排，从
        //而得到中位数；
        if(e-s<scope){
            insertSort(arr,s,e);
            res[k++] = arr[(s+e) >> 1];
        }
        else{
            //如果e-s>=scope,那么设置步长为scope的窗口，逐步进
            //行寻找每一段的中位数。
            int i=s,j=0,splitStart =0 ,splitEnd = 0;
            while(i++<=e){
                if(++j == scope){
                    // 窗口的起始位置；
                    splitStart = k*scope+s;
                    //窗口的结束位置；
                    splitEnd = (k+1)*scope+s-1;
                    insertSort(arr,splitStart,splitEnd);
                    res[k++] = arr[(splitStart+splitEnd) >> 1];
                    j=0;
                }
            }
            //说明(e-s)%scope !=0, 需要把最后一小段加进去
            if(splitEnd < e){
                insertSort(arr,splitEnd+1,e);
                res[k++] = arr[(splitEnd+1+e) >> 1];
            }
        }
        return res;
    }


    /***
     * 快排，对{arr[s]~arr[e]}这一段进行快排
     * @param arr
     * @param s start
     * @param e end
     * @return
     */
    public static int[] insertSort(int[] arr,int s,int e){
        for(int i=s;i<=e;i++){
            int key = i;
            for(int j=i-1;j>=s;j--){
                if(arr[key] < arr[j]){
                    swap(arr,key,j);
                    key --;
                }
                else{
                    break;
                }
            }
        }
        return arr;
    }

    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] =tmp;
    }

    /***
     * 给定一个king,对于{arr[s]~arr[e]}这一段进行partition
     * @param arr
     * @param s start
     * @param e end
     * @param king 用于partition的king
     * @return
     */
    public static int partition(int[] arr,int s,int e,int king){
        int i = s;
        int j = e;
        int kingIndex = 0;

        for(int k =s;k<=e;k++){
            if(arr[k]==king){
                kingIndex = k;
                break;
            }
        }
        while(i<j){
            while(arr[j]>=king && j>kingIndex){
                j--;
            }
            swap(arr,j,kingIndex);
            kingIndex=j;
            while(arr[i]<= king && i<kingIndex){
                i++;
            }
            swap(arr,i,kingIndex);
            kingIndex=i;
        }
        return i;
    }
}