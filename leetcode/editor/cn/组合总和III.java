package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 👍 337 👎 0

public class 组合总和III{
	public static void main(String[] args) {
		Solution solution = new 组合总和III().new Solution();
	    solution.combinationSum3(3, 7);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
		this.target = n;
		int[] candidates = {1,2,3,4,5,6,7,8,9};
		ArrayList<Integer> choices = (ArrayList<Integer>) Arrays.stream(candidates).boxed().collect(Collectors.toList());
		backTrack(new ArrayList<Integer>(), choices, k, 0);
		return results;
    }
    public List<List<Integer>> results = new ArrayList<>();
    public int target;
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices, int number, int sum){
    	if(sum == target && number==0){
    		results.add(path);
    		return;
		}
    	if(sum > target){
    		return;
		}
    	if(number == 0){
    		return;
		}

		ArrayList<Integer> choicesCopy = new ArrayList<Integer>(choices);
    	for(int choice : choices){
    		ArrayList<Integer> newPath = new ArrayList<>(path);
    		newPath.add(choice);
    		choicesCopy.remove((Integer) choice);
    		backTrack(newPath, choicesCopy, number-1, sum+choice);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
