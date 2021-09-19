package leetcode.editor.cn;
import java.util.*;
//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 677 👎 0

public class 组合{
	public static void main(String[] args) {
		Solution solution = new 组合().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> choices = new ArrayList<>();
        this.n = n;
        this.k = k;
        for(int i=0;i<n;i++){
            choices.add(i+1);
        }
        backTrack(new ArrayList<Integer>(), choices, k);
        return results;
    }
    public int n, k;
    public List<List<Integer>> results = new ArrayList<>();
    public void backTrack(ArrayList<Integer> path, ArrayList<Integer> choices, int num){
        if(choices.size()==0 && path.size()==k){
            results.add(path);
            return;
        }
        if(num == 0){
            results.add(path);
            return;
        }
        if(n - path.size() < num){
            return;
        }
        ArrayList<Integer> choicesCopy = new ArrayList<>(choices);
        num = num - 1;
        for(int choice : choices){
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.add(choice);
            choicesCopy.remove((Integer) choice);
            backTrack(newPath, choicesCopy, num);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
