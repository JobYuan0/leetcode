package leetcode.editor.cn;
import java.util.*;
import java.util.stream.Collectors;
//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 192 👎 0

public class 通过删除字母匹配到字典里最长单词{
	public static void main(String[] args) {
		Solution solution = new 通过删除字母匹配到字典里最长单词().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
		Collections.sort(dictionary, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length()){
					return -(o1.length() - o2.length());
				} else {
					return o1.compareTo(o2);
				}
			}
		});
		char[] charArray = s.toCharArray();
		int length = dictionary.size();
		for(int i=0;i<length;i++){
			String str = dictionary.get(i);
			// charArray是否包含str
			if(check(str, charArray)){
				return str;
			}
		}
		return "";
    }

    public boolean check(String str, char[] charArray){
    	if(charArray.length < str.length()){
    		return false;
		}
    	char[] cA2 = str.toCharArray();
    	int length = cA2.length;
		int i=0,j=0;
		while (i<length && j<charArray.length){
			if(cA2[i] == charArray[j]){
				i++;
				j++;
			}
			else {
				j++;
			}
		}
		if(i==length){
			return true;
		} else {
			return false;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
