package aa;

import java.util.*;

class TreeNode {
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

class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        this.traverse(root);
        return this.res;
    }
    public void traverse(TreeNode root){
        if (root != null){
            this.res.add(root.val);
            this.preorderTraversal(root.left);
            this.preorderTraversal(root.right);
        }
    }
}