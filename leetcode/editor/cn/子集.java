package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1298 👎 0

public class 子集{
	public static void main(String[] args) {
		Solution solution = new 子集().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		ArrayList<Integer> choices = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
		backTrack(new ArrayList<Integer>(), choices);
		return results;
    }
    public List<List<Integer>> results = new ArrayList<>();
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices){
		results.add(path);
		if(choices.size()==0){
    		return;
		}
		ArrayList<Integer> choicesCopy = new ArrayList<>(choices);
		for(int choice : choices){
			ArrayList<Integer> newPath = new ArrayList<>(path);
			newPath.add(choice);
			choicesCopy.remove((Integer) choice);
			backTrack(newPath, choicesCopy);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
