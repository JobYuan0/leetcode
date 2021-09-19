package leetcode.editor.cn;
import javafx.util.Pair;

import java.util.*;
//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 485 👎 0

public class 单词搜索II{
	public static void main(String[] args) {
		Solution solution = new 单词搜索II().new Solution();
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		solution.findWords(board, words);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
    	// 0.从words中去除board所不包含字母的字符串
		row = board.length;
		col = board[0].length;
		HashSet<Character> allChar = new HashSet<>();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				allChar.add(board[i][j]);
			}
		}
		List<String> words2 = new ArrayList<String>();
		for(int i=0;i<words.length;i++){
			String word = words[i];
			boolean flag = true;
			for(char c : word.toCharArray()){
				if(!allChar.contains(c)){
					flag = false;
					break;
				}
			}
			if(flag){
				words2.add(word);
			}
		}
		this.words = words2;

		this.board = board;
		// 1.首先存储words第i个字母的集合
		hashSets = new ArrayList<>();
		for(int i=0;i<12;i++){
			HashSet<Character> characters = new HashSet<>();
			hashSets.add(characters);
		}
		wordsLength = new int[this.words.size()];
		for(int i=0;i<this.words.size();i++){
			String word = this.words.get(i);
			int length = word.length();
			wordsLength[i] = length;
			for(int j=0;j<length;j++){
				HashSet<Character> characters = hashSets.get(j);
				characters.add(word.charAt(j));
			}
		}
		// 2.开始回溯遍历

		boolean[][] visited = new boolean[row][col];

		StringBuilder path = new StringBuilder();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				path.append(board[i][j]);
				visited[i][j] = true;
				backTrack(path, i, j, 1, visited);
				visited[i][j] = false;
				path.deleteCharAt(path.length()-1);
			}
		}
		return results;
	}

	ArrayList<HashSet<Character>> hashSets;
	List<String> words;
    int[] wordsLength;
	char[][] board;
	public int row;
	public int col;
	public List<String> results = new ArrayList<String>();

    public void backTrack(StringBuilder path, int i, int j, int k, boolean[][] visited){
		// 首先判断path在不在words中
		if(contains(path)){
			results.add(path.toString());
		}
    	// 生成choices
		List<Pair<Integer, Integer>> choices = getChoices(visited, i, j, k);
		if(choices.isEmpty()){
			return;
		}
		for(Pair<Integer, Integer> choice : choices){
			int ii=choice.getKey(), jj=choice.getValue();
			path.append(board[ii][jj]);
			visited[ii][jj] = true;
			backTrack(path, ii, jj, k+1, visited);
			visited[ii][jj] = false;
			path.deleteCharAt(path.length()-1);
		}

	}
	// 判断words是否包含path
	public boolean contains(StringBuilder path){
    	int length = path.length();
    	for(int i=0;i<wordsLength.length;i++){
    		if(length == wordsLength[i]){
    			if(words.get(i).equals(path.toString())){
    				// 防止重复
    				wordsLength[i] = -1;
    				return true;
				}
			}
		}
    	return false;
	}

	public List<Pair<Integer, Integer>> getChoices(boolean[][] visited, int i, int j, int k){
		List<Pair<Integer, Integer>> choices = new ArrayList<>();
		// 判断(i,j)上面的位置可不可以作为一个choice
		if(j-1>=0){
			if(visited[i][j-1]==false && hashSets.get(k).contains(board[i][j-1])){
				choices.add(new Pair<>(i, j-1));
			}
		}
		// 判断(i,j)左边的位置可不可以作为一个choice
		if(i-1>=0){
			if(visited[i-1][j]==false && hashSets.get(k).contains(board[i-1][j])){
				choices.add(new Pair<>(i-1, j));
			}
		}
		// 判断(i,j)右边的位置可不可以作为一个choice
		if(j+1<col){
			if(visited[i][j+1]==false && hashSets.get(k).contains(board[i][j+1])){
				choices.add(new Pair<>(i, j+1));
			}
		}
		// 判断(i,j)下面的位置可不可以作为一个choice
		if(i+1<row){
			if(visited[i+1][j]==false && hashSets.get(k).contains(board[i+1][j])){
				choices.add(new Pair<>(i+1, j));
			}
		}
		return choices;
	}


}
//leetcode submit region end(Prohibit modification and deletion)

}
