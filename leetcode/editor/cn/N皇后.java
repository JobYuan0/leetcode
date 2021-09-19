package leetcode.editor.cn;
import java.util.*;
//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
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
// Related Topics 数组 回溯 👍 983 👎 0

public class N皇后{
	public static void main(String[] args) {
		Solution solution = new N皇后().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
		this.n = n;
		backTrack(new ArrayList<String>(), 0, new ArrayList<Integer>());
		return results;
    }
    public List<List<String>> results = new ArrayList<>();
    public int n;
    public void backTrack(ArrayList<String> path, int row, ArrayList<Integer> a){
    	if(row == n){
    		results.add(path);
    		return;
		}
    	for(int i=0;i<n;i++){
			ArrayList<String> newPath = new ArrayList<>(path);
			boolean flag = true;
    		for(int j=1;j<=row;j++){
    			if(a.get(row-j).equals(i+j) || a.get(row-j).equals(i-j)
						|| a.get(row-j).equals(i)){
    				flag = false;
//    				System.out.println("break");
//    				System.out.println(""+i+j);
    				break;
				}
			}
    		if(flag){
				StringBuilder str = new StringBuilder();
				for(int k=0;k<this.n-1;k++){
					str.append('.');
				}
				str.insert(i, 'Q');
				newPath.add(new String(str));
				ArrayList<Integer> aCopy = new ArrayList<>(a);
				aCopy.add(i);
				backTrack(newPath, row+1, aCopy);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
