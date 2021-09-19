package leetcode.editor.cn;
import java.util.*;
//你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [
//attacki, defensei] 表示游戏中第 i 个角色的属性。 
//
// 如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 
//j ，那么 attackj > attacki 且 defensej > defensei 。 
//
// 返回 弱角色 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：properties = [[5,5],[6,3],[3,6]]
//输出：0
//解释：不存在攻击和防御都严格高于其他角色的角色。
// 
//
// 示例 2： 
//
// 
//输入：properties = [[2,2],[3,3]]
//输出：1
//解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 示例 3： 
//
// 
//输入：properties = [[1,5],[10,4],[4,3]]
//输出：1
//解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= properties.length <= 10⁵ 
// properties[i].length == 2 
// 1 <= attacki, defensei <= 10⁵ 
// 
// Related Topics 栈 贪心 数组 排序 单调栈 👍 24 👎 0

public class 游戏中弱角色的数量{
	public static void main(String[] args) {
		Solution solution = new 游戏中弱角色的数量().new Solution();
		int[][] properties = {{5,5},{6,3},{3,6}};
		solution.numberOfWeakCharacters(properties);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
		Arrays.sort(properties, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] != o2[0]){
					return o2[0] - o1[0];
				}
				else {
					return o1[1] - o2[1];
				}
			}
		});
		int length = properties.length;
		int max = -1;
		int res = 0;
		for(int i=0;i<length;i++){
			int de = properties[i][1];
			if(de < max){
				res++;
			}
			max = Math.max(max, de);
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
