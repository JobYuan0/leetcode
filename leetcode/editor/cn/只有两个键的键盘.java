package leetcode.editor.cn;
import java.util.*;
//最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。 
// Paste（粘贴）：粘贴 上一次 复制的字符。 
// 
//
// 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。 
//
//
//
// 示例 1： 
//
// 
//输入：3
//输出：3
//解释：
//最初, 只有一个字符 'A'。
//第 1 步, 使用 Copy All 操作。
//第 2 步, 使用 Paste 操作来获得 'AA'。
//第 3 步, 使用 Paste 操作来获得 'AAA'。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
// Related Topics 数学 动态规划 👍 334 👎 0

public class 只有两个键的键盘{
	public static void main(String[] args) {
		Solution solution = new 只有两个键的键盘().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSteps(int n) {
		int[][] dp = new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[1][1] = 0;

		for(int j=2;j<=n;j++){
			for(int i=1;i<=j;i++){
				if(i==1){
					// 第一行的
					int min = Integer.MAX_VALUE;
					// 遍历dp[i-k][j+k]  k (1,i/2]
					for(int k=2;k<=j/2;k++){
						min = Math.min(min, dp[j-k][i+k]+1);
					}
					// 遍历dp[i-1,:]
					for(int k=0;k<=j-1;k++){
						min = Math.min(min, dp[j-1][k]+1);
					}
					dp[i][j] = min;
				}
				else if(i==j){
					dp[i][j] = Math.min(dp[i][j], dp[j-i][i]+1);
				}
				else {

				}
			}
		}
		return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
