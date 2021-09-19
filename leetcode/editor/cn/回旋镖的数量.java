package leetcode.editor.cn;
import java.util.*;
//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 👍 215 👎 0

public class 回旋镖的数量{
	public static void main(String[] args) {
		Solution solution = new 回旋镖的数量().new Solution();
	    
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> distances = new HashMap<>();
		int res = 0;
		int length = points.length;
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				// 计算两点距离
				int distance = getDistance(points[i], points[j]);
				if(distances.containsKey(distance)){
					distances.put(distance, distances.get(distance)+1);
				} else {
					distances.put(distance, 1);
				}
			}
			for(Map.Entry<Integer, Integer> entry : distances.entrySet()){
				int num = entry.getValue();
				if(num>1){
					res += num * (num-1);
				}
			}
			distances.clear();
		}
		return res;
    }

    public int getDistance(int[] p1, int[] p2){
    	return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
