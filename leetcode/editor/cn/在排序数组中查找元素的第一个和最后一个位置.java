package leetcode.editor.cn;
import java.util.*;
//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1176 👎 0

public class 在排序数组中查找元素的第一个和最后一个位置{
	public static void main(String[] args) {
		Solution solution = new 在排序数组中查找元素的第一个和最后一个位置().new Solution();
	    int[] nums = {5,7,7,8,8,10};
	    solution.searchRange(nums, 8);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
    	if(nums.length == 0){
			int[] results = {-1, -1};
    		return results;
		}
    	int[] results = new int[2];
		int left = 0, right = nums.length - 1;
		while (left < right){
			int mid = left + (right - left) / 2;
			if(nums[mid] >= target){
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		if(nums[left] == target){
			results[0] = left;
		} else {
			results[0] = -1;
			results[1] = -1;
			return results;
		}

		left = 0;
		right = nums.length - 1;
		while (left < right){
			int mid = left + (right - left + 1) / 2;
			if(nums[mid] <= target){
				left = mid;
			}
			else {
				right = mid - 1;
			}
		}
		results[1] = left;
		return results;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
