package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1489 👎 0

public class 组合总和{
	public static void main(String[] args) {
		Solution solution = new 组合总和().new Solution();
		int[] candidates = {2,3,6,7};
		solution.combinationSum(candidates, 7);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	this.results = new ArrayList<List<Integer>>();
		this.target = target;
		this.choices = (ArrayList<Integer>) Arrays.stream(candidates).boxed().collect(Collectors.toList());
    	this.backTrack(new ArrayList<Integer>(), this.choices, 0);
    	return results;
    }
    public List<List<Integer>> results;
    public ArrayList<Integer> choices;
    public int target;
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices, int sum){
    	if(sum == target){
    		results.add(path);
    		return;
		}
    	if(sum > target){
    		return;
		}
		ArrayList<Integer> choicesCopy = new ArrayList<Integer>(choices);
    	for(int choice : choices){
    		ArrayList<Integer> newPath = new ArrayList<Integer>(path);
			newPath.add(choice);
    		backTrack(newPath, new ArrayList<Integer>(choicesCopy), sum+choice);
			choicesCopy.remove((Integer) choice);
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
