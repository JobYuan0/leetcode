package leetcode.editor.cn;
import java.util.*;
//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2ʰ 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 10⁴] 
// 0 <= Node.val <= 5 * 10⁴ 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 👍 532 👎 0

public class 完全二叉树的节点个数{
	public static void main(String[] args) {
		Solution solution = new 完全二叉树的节点个数().new Solution();
	    TreeNode t1 = new 完全二叉树的节点个数().getTreeNode(1);
	    TreeNode t2 = new 完全二叉树的节点个数().getTreeNode(2);
	    TreeNode t3 = new 完全二叉树的节点个数().getTreeNode(3);
	    TreeNode t4 = new 完全二叉树的节点个数().getTreeNode(4);
	    TreeNode t5 = new 完全二叉树的节点个数().getTreeNode(5);
	    TreeNode t6 = new 完全二叉树的节点个数().getTreeNode(6);
	    TreeNode t7 = new 完全二叉树的节点个数().getTreeNode(67);
	    t1.left = t2;
	    t1.right = t3;
	    t2.left = t4;
	    t2.right = t5;
	    t3.left = t6;
	    t3.right = t7;
	    solution.countNodes(t1);
	}
//leetcode submit region begin(Prohibit modification and deletion)

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public TreeNode getTreeNode(int val){
		return new TreeNode(val);
	}

class Solution {
    public int countNodes(TreeNode root) {
		//1.首先得到树的深度
		this.root = root;
		int depth = 0;
		TreeNode root2 = root;
		while (root2!=null){
			root2 = root2.left;
			depth++;
		}
		if(depth==1){
			return 1;
		}
		if(depth==0)
			return 0;
		// 2.然后二分查找，用数字表示从root到叶子节点的路径
		//  已知最后一层第一个节点的编号为2^k,上面一共2^k - 1个节点,k=depth-1
		//  关键在于如何将数字转化为路径序列
		int k = depth - 1;
		int left = 1 << k;
		int right = (1 << (k+1)) - 1;
		while (left<right){
			int mid = left + (right - left + 1) / 2;
			if (check(mid, k)){
				left = mid;
			} else {
				right = mid-1;
			}
		}
		for(int i=k-1;i>=0;i--){
			if((left&(1<<i))==0){
				root = root.left;
			} else {
				root = root.right;
			}
		}
		System.out.println(root.val);
		return left;

    }
	TreeNode root;

	public boolean check(int mid, int k){
		// 树是否包含mid对应节点
		TreeNode treeNode = root;
		// 先按照路径走到倒数第二层，即i=1
		for(int i=k-1;i>0;i--){
			boolean isLeft = (mid & (1 << i)) == 0;
			if(isLeft == false){
				treeNode = treeNode.right;
			} else {
				treeNode = treeNode.left;
			}
		}
		boolean isLeft = (mid & (1 << 0)) == 0;
		if(isLeft == false){
			return treeNode.right!=null;
		} else {
			return treeNode.left!=null;
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
