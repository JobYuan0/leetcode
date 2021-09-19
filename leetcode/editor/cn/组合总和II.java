package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 672 👎 0

public class 组合总和II{
	public static void main(String[] args) {
		Solution solution = new 组合总和II().new Solution();
		int[] candidates = {1,1};
		solution.combinationSum2(candidates, 1);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		this.target = target;
		ArrayList<Integer> choices = (ArrayList<Integer>) Arrays.stream(candidates).boxed().collect(Collectors.toList());
    	backTrack(new ArrayList<Integer>(), choices, 0);
    	return results;
    }
    public int target;
    public List<List<Integer>> results = new ArrayList<List<Integer>>();
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices, int sum){
    	if(sum > target){
    		return;
		}
    	if(sum == target){
    		results.add(path);
    		return;
		}
    	// 首先建立choices的复制，然后对choices去重
    	ArrayList<Integer> choicesCopy = new ArrayList<Integer>(choices);
		choices = (ArrayList<Integer>) choices.stream().distinct().collect(Collectors.toList());
    	for(int choice : choices){
    		ArrayList<Integer> newPath = new ArrayList<Integer>(path);
			newPath.add(choice);
			choicesCopy.remove((Integer) choice);
    		backTrack(newPath, choicesCopy, sum+choice);
			while (choicesCopy.contains((Integer) choice)){
				choicesCopy.remove((Integer) choice);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
