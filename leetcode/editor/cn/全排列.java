package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1510 👎 0

public class 全排列{
	public static void main(String[] args) {
		Solution solution = new 全排列().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
		ArrayList<Integer> choices = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
    	backTrack(new ArrayList<Integer>(), choices);
    	return results;
    }
    public List<List<Integer>> results = new ArrayList<>();
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices){
    	if(choices.size()==0){
    		results.add(path);
    		return;
		}
    	for(int choice : choices){
			ArrayList<Integer> choicesCopy = new ArrayList<>(choices);
			ArrayList<Integer> newPath = new ArrayList<>(path);
			newPath.add(choice);
			choicesCopy.remove((Integer) choice);
			backTrack(newPath, choicesCopy);
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
