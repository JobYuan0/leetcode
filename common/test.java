package common;

import java.util.*;

/**
 * @author yuanyibo
 * @create 2021/09/19 10:30
 */
public class test {


    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for(String str : operations){
            if("++X".equals(str) || "X++".equals(str)){
                x++;
            } else {
                x--;
            }
        }
        return x;
    }

    public int sumOfBeauties(int[] nums) {
        int num=0;
        int res=0;
        for(int i=1;i<=nums.length-2;i++){
            if(nums[i] < nums[i-1] || nums[i] > nums[i+1]){
                num++;
            }
            if(nums[i] > nums[i-1] && nums[i] < nums[i+1]){
                res++;
            }
        }
        if(num==0){
            res = res << 1;
        }
        return res;
    }


}
