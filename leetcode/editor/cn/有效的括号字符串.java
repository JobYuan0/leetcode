package leetcode.editor.cn;
import java.util.*;
//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 👍 385 👎 0

public class 有效的括号字符串{
	public static void main(String[] args) {
		Solution solution = new 有效的括号字符串().new Solution();
		String s = "(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())";
	    solution.checkValidString(s);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkValidString(String s) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		char[] charArray = s.toCharArray();
		int length = s.length();
		for(int i=0;i<length;i++){
			if(charArray[i] == '('){
				stack1.push(i);
			}
			else if(charArray[i] == '*'){
				stack2.push(i);
			}
			else {
				if(!stack1.empty()){
					stack1.pop();
				}
				else {
					if(!stack2.empty()){
						stack2.pop();
					}else {
						return false;
					}
				}
			}
		}
		// 结束后判断，栈里面应只有'('和'*'
		while (!stack1.empty() && !stack2.empty()){
			int leftIndex = stack1.pop();
			int asteriskIndex = stack2.pop();
			if (leftIndex > asteriskIndex) {
				return false;
			}
		}
		return stack1.empty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
