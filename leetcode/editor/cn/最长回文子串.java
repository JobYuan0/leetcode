package leetcode.editor.cn;
import java.util.*;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 👍 4064 👎 0

public class 最长回文子串{
	public static void main(String[] args) {
		Solution solution = new 最长回文子串().new Solution();
	    String s = "aaaa";
	    solution.longestPalindrome(s);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
		int length = s.length();
		char[] charArray = s.toCharArray();
		boolean[][] dp = new boolean[length][length];
		int maxLength = Integer.MIN_VALUE;
		int left=0, right=0;
		for(int i=0;i<length;i++){
			dp[i][i] = true;
		}
		for(int i=1;i<length;i++){
			dp[i-1][i] = charArray[i-1] == charArray[i];
			if(dp[i-1][i]){
				if(maxLength < 1){
					maxLength = 1;
					left = i-1;
					right = i;
				}
			}
		}
		for(int col=2;col<length;col++) {
			for (int row = 0; row < col-1; row++) {
				dp[row][col] = dp[row + 1][col - 1] && (charArray[row] == charArray[col]);
				if(dp[row][col]){
					if(maxLength < col - row + 1){
						maxLength = col - row + 1;
						left = row;
						right = col;
					}
				}
			}
		}

		return s.substring(left, right+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
