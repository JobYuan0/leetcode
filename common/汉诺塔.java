package common;

/**
 * @author yuanyibo
 * @create 2021/09/18 10:09
 */
public class 汉诺塔 {

    public static void main(String[] args) {
        汉诺塔 test = new 汉诺塔();
        test.hannoi(10, 'A', 'B', 'C');
    }

    public void move(int num, char from, char to){
        System.out.println("move "+from+":"+num+" -> "+to+":"+num);
    }

    /**
     * 基于递归的方法：
     * 子问题，将中间柱子上的全部圆盘移动到右边柱子上,即 mid -> right
     * 或者更抽象地表示为：将一个柱子上的前n个圆盘移动到另一个柱子上
    */
    public void hannoi(int n, char left, char mid, char right){
        if(n==1){
            move(n, mid, right);
            return;
        }
        // 1.首先将中间柱子的前n-1个移动到左边柱子上
        hannoi(n-1, right, mid, left);
        // 2.然后将中间剩余的那个移动到右边柱子上
        move(n, mid, right);
        // 3.最后将左边柱子的n-1个移动到右边柱子上
        hannoi(n-1, mid, left, right);
    }

    /**
     * 基于搜索的方法
    */
    public void hannoi2(int n){

    }

}
