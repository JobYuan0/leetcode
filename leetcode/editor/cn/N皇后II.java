package leetcode.editor.cn;
import java.util.*;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯 👍 285 👎 0

public class N皇后II{
	public static void main(String[] args) {
		Solution solution = new N皇后II().new Solution();

	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
		this.n = n;
		backTrack(0, new ArrayList<Integer>());
		return results;
    }
	public int results = 0;
	public int n;
	public void backTrack(int row, ArrayList<Integer> a){
		if(row == n){
			results++;
			return;
		}
		for(int i=0;i<n;i++){
			boolean flag = true;
			for(int j=1;j<=row;j++){
				if(a.get(row-j).equals(i+j) || a.get(row-j).equals(i-j)
						|| a.get(row-j).equals(i)){
					flag = false;
					break;
				}
			}
			if(flag){
				ArrayList<Integer> aCopy = new ArrayList<>(a);
				aCopy.add(i);
				backTrack(row+1, aCopy);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
