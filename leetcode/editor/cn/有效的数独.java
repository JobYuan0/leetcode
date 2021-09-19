package leetcode.editor.cn;
import java.util.*;
//请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 
// Related Topics 数组 哈希表 矩阵 👍 589 👎 0

public class 有效的数独{
	public static void main(String[] args) {
		Solution solution = new 有效的数独().new Solution();
		char[][] board = {
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'5','3','.','.','7','.','.','.','.'},
				{'5','3','.','.','7','.','.','.','.'},
				{'5','3','.','.','7','.','.','.','.'},
				{'5','3','.','.','7','.','.','.','.'},
				{'5','3','.','.','7','.','.','.','.'}};
//		solution.isValidSudoku(board);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValidSudoku(char[][] board) {
		//1.先判断3*3是否满足
		HashSet<Character> characters = new HashSet<>();
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++){
				for(int i=0;i<3;i++){
					for(int j=0;j<3;j++){
						if(characters.contains(board[i+row*3][j+col*3]) && board[i+row*3][j+col*3]!='.'){
							return false;
						} else {
							characters.add(board[i+row*3][j+col*3]);
						}
					}
				}
				characters.clear();
			}
		}
		System.out.println("3*3 OK");
		//2.判断行是否满足
		for(int row=0;row<9;row++){
			for(int col=0;col<9;col++){
				if(characters.contains(board[row][col]) && board[row][col]!='.'){
					return false;
				} else {
					characters.add(board[row][col]);
				}
			}
			characters.clear();
		}
		System.out.println("row OK");

		//3.判断列是否满足
		for(int col=0;col<9;col++){
			for(int row=0;row<9;row++){
				if(characters.contains(board[row][col]) && board[row][col]!='.'){
					return false;
				} else {
					characters.add(board[row][col]);
				}
			}
			characters.clear();
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
