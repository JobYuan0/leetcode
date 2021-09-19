package leetcode.editor.cn;
import java.util.*;
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1460 👎 0

public class 电话号码的字母组合{
	public static void main(String[] args) {
		Solution solution = new 电话号码的字母组合().new Solution();
	    solution.letterCombinations("234");
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
    	if(digits.length()==0){
    		return new ArrayList<String>();
		}
    	Map<Character, String> phoneMap = new HashMap<Character, String>(){{
    		put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}};
    	List<String> choices = new ArrayList<String>();
    	int length = digits.length();
		for(int i=0;i<length;i++){
			choices.add(phoneMap.get(digits.charAt(i)));
		}
    	backTrack("", choices);
		return results;
    }
	public List<String> results = new ArrayList<String>();
    public void backTrack(String path, List<String> choices){
		// 每次只对String的List的第一个String做选择，当List为空则表示结束
		// 结束条件
		if(choices.size() == 0){
			results.add(path);
			return;
		}
		// 遍历选择
		String choice = choices.get(0);
		choices.remove(choice);
		StringBuilder stringBuilder = new StringBuilder(choice);
		int length = choice.length();
		for(int i=0;i<length;i++){
			char word = stringBuilder.charAt(i);
			backTrack(path+word, new ArrayList<String>(choices));
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
