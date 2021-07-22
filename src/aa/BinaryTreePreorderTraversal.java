package aa;

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