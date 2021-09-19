package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3734 👎 0

public class 三数之和{
	public static void main(String[] args) {
		Solution solution = new 三数之和().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		List<Integer> choices = Arrays.stream(nums).boxed().collect(Collectors.toList());
		backTrack(new ArrayList<>(), choices, 0, 0);
		return results;
    }

    public List<List<Integer>> results = new ArrayList<>();

    public void backTrack(List<Integer> path, List<Integer> choices, int error, int k){
    	if(k == 3){
    		if(error == 0){
    			results.add(path);
			}
			return;
		}
		List<Integer> choicesCopy = new ArrayList<>(choices);
		for(int choice : new HashSet<>(choices)){

			List<Integer> newPath = new ArrayList<>(path);
    		newPath.add(choice);
    		choicesCopy.remove((Integer) choice);
    		backTrack(newPath, choicesCopy, error-choice, k+1);
    		while (choicesCopy.contains(choice)){
    			choicesCopy.remove((Integer) choice);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
