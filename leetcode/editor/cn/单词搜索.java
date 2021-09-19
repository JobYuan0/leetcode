package leetcode.editor.cn;
import javafx.util.Pair;

import java.util.*;
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1015 👎 0

public class 单词搜索{
	public static void main(String[] args) {
		Solution solution = new 单词搜索().new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
	    boolean result = solution.exist(board, "SEE");
	    System.out.println(result);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {
		this.word = word;
		this.board = board;
		this.row = board.length;
		this.col = board[0].length;
		boolean[][] visited = new boolean[row][col];
		ArrayList<Character> path = new ArrayList<>();
		for(int i=0;i<row;i++){
			for (int j=0;j<col;j++){
				path.add(board[i][j]);
				visited[i][j] = true;
				backTrack(path, i, j, visited);
				visited[i][j] = false;
				path.remove(path.size()-1);
			}
		}
    	return result;
    }
    public char[][] board;
    public boolean result;
    public String word;
    public int row;
    public int col;
    public void backTrack(List<Character> path,
						  int i, int j, boolean[][] visited){
    	if(path.size()>word.length()){
    		return;
		}
    	int pathLength = path.size();
    	if(pathLength>0){
			if(word.charAt(pathLength-1)!=path.get(pathLength-1)){
				return;
			}
		}

    	//根据当前下标和visited选出可能的choices
		List<Pair<Integer, Integer>> choices = getChoices(visited, i, j);

		if(path.size() == word.length()){
			StringBuilder sb = new StringBuilder();
			for (Character ch :path){
				sb.append(ch);
			}
			String res = sb.toString();
    		if(res.equals(word)){
    			result = true;
    			return;
			}
		}
    	for(Pair<Integer, Integer> choice : choices){
    		int ii = choice.getKey(), jj = choice.getValue();
			char c = board[ii][jj];
			path.add(c);
			visited[ii][jj] = true;
			backTrack(path, ii, jj, visited);
			visited[ii][jj] = false;
			path.remove(path.size()-1);
		}
	}


	public List<Pair<Integer, Integer>> getChoices(boolean[][] visited, int i, int j){
		List<Pair<Integer, Integer>> choices = new ArrayList<>();
		// 判断(i,j)上面的位置可不可以作为一个choice
		if(j-1>=0){
			if(visited[i][j-1]==false){
				choices.add(new Pair<>(i, j-1));
			}
		}
		// 判断(i,j)左边的位置可不可以作为一个choice
		if(i-1>=0){
			if(visited[i-1][j]==false){
				choices.add(new Pair<>(i-1, j));
			}
		}
		// 判断(i,j)右边的位置可不可以作为一个choice
		if(j+1<col){
			if(visited[i][j+1]==false){
				choices.add(new Pair<>(i, j+1));
			}
		}
		// 判断(i,j)下面的位置可不可以作为一个choice
		if(i+1<row){
			if(visited[i+1][j]==false){
				choices.add(new Pair<>(i+1, j));
			}
		}
		return choices;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
