package leetcode.editor.cn;
import java.util.*;
//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 757 👎 0

public class 长度最小的子数组{
	public static void main(String[] args) {
		Solution solution = new 长度最小的子数组().new Solution();
		int[] a = {1,4,4};
	    solution.minSubArrayLen(4, a);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
		//1.暴力。
//		int n = nums.length;
//		if(n == 0){
//			return 0;
//		}
//		int ans = Integer.MAX_VALUE;
//		for(int i=0;i<n;i++){
//			int sum = 0;
//			for(int j=i;j<n;j++){
//				sum += nums[j];
//				if(sum >= target){
//					ans = Math.min(j-i+1, ans);
//					break;
//				}
//			}
//		}
//		return ans==Integer.MAX_VALUE?0:ans;
		// 2.前缀和+二分
//		int n = nums.length;
//		if(n == 0){
//			return 0;
//		}
//		int[] sums = new int[n];
//		sums[0] = nums[0];
//		for(int i=1;i<n;i++){
//			sums[i] = sums[i-1] + nums[i];
//		}
//		int ans = Integer.MAX_VALUE;
//		for(int i=0;i<n;i++){
//			int left = i;
//			int right = n-1;
//			while (left < right){
//				int mid = left + (right-left)/2;
//				// 我的目的是找到[i,mid]的总和值
//				int sum = sums[mid];
//				if(i!=0){
//					sum = sums[mid] - sums[i-1];
//				}
//				if(sum >= target){
//					right = mid;
//				}
//				else {
//					left = mid + 1;
//				}
//			}
//			int sum = sums[left];
//			if(i!=0){
//				sum = sums[left] - sums[i-1];
//			}
//			if(sum >= target){
//				ans = Math.min(ans, left + 1 - i);
//			}
//		}
//		return ans==Integer.MAX_VALUE?0:ans;
		// 3.滑动窗口
		int n = nums.length;
		int left = 0, right = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;
		while (right < n){
			sum += nums[right];
			while (sum >= target){
				ans = Math.min(ans, right-left+1);
				sum -= nums[left];
				left++;
			}
			right++;
		}
		return ans==Integer.MAX_VALUE?0:ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
