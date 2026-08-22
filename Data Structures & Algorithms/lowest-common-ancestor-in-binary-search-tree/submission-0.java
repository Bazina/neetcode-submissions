/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> pParents = bstSearch(root, p);
        ArrayList<TreeNode> qParents = bstSearch(root, q);
        TreeNode commonParent = null;
        int i = 0, j = 0;

        for (; i < pParents.size() && j < qParents.size(); i++, j++) {
            if (pParents.get(i) == qParents.get(j)) {
                commonParent = pParents.get(i);
            } else {
                break;
            }
        }

        return commonParent;
    }

    public ArrayList<TreeNode> bstSearch(TreeNode root, TreeNode p) {
        ArrayList<TreeNode> parents = new ArrayList<>();
        while (root != null && root != p) {
            parents.add(root);
            if (root.val > p.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            }
        }
        parents.add(p);
        return parents;
    }
}
