package leetcode.editor.cn;
import java.util.*;
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 有效括号组合需满足：左括号必须以正确的顺序闭合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 1980 👎 0

public class 括号生成{
	public static void main(String[] args) {
		Solution solution = new 括号生成().new Solution();
	    solution.generateParenthesis(3);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	public List<String> results = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
		backTrack(new StringBuilder(), n, n);
    	return results;
    }
    public void backTrack(StringBuilder path, int leftNumber, int rightNumber){
    	if(leftNumber == 0 && rightNumber ==0){
    		results.add(new String(path));
    		return;
		}
    	if(leftNumber == rightNumber){
    		backTrack(new StringBuilder(path.append('(')), leftNumber-1, rightNumber);
    		return;
		}
    	if(leftNumber == 0){
			backTrack(new StringBuilder(path.append(')')), leftNumber, rightNumber-1);
			return;
		}
    	else{
    		for(int i=0;i<2;i++){
    			if(i==0){
					backTrack(new StringBuilder(path).append('('), leftNumber-1, rightNumber);
				}
    			else {
					backTrack(new StringBuilder(path).append(')'), leftNumber, rightNumber-1);
				}
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
