package leetcode.editor.cn;
import java.util.*;
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 495 👎 0

public class 搜索二维矩阵{
	public static void main(String[] args) {
		Solution solution = new 搜索二维矩阵().new Solution();
		int[][] nums = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		solution.searchMatrix(nums, 3);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
		// 建立n与二维坐标的映射
//		int n = i * row + j;
//		int i = n / row;
//		int j = n % row;
		int row = matrix.length;
		int col = matrix[0].length;
		int left = 0;
		int right = row * col - 1;
		while (left < right){
			int mid = left + (right - left) / 2;
			int i = mid / row;
			int j = mid % row;
			if(matrix[i][j] >= target){
				right = mid;
			}
			else {
				left = mid + 1;
			}
		}
		int i = left / row;
		int j = left % row;
		return matrix[i][j] == target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
