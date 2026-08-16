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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> bfs = new LinkedList<>();
        if (q != null && p != null) {
            bfs.offer(q);
            bfs.offer(p);
        } else if (q != null || p != null) {
            return false;
        }

        while (!bfs.isEmpty()) {
            int size = bfs.size() / 2;
            for (int i = 0; i < size; i++) {
                TreeNode qTree = bfs.poll();
                TreeNode pTree = bfs.poll();

                if (qTree.val == pTree.val) {
                    if (qTree.right != null && pTree.right != null) {
                        bfs.offer(qTree.right);
                        bfs.offer(pTree.right);
                    } else if (qTree.right != null || pTree.right != null) {
                        return false;
                    }

                    if (qTree.left != null && pTree.left != null) {
                        bfs.offer(qTree.left);
                        bfs.offer(pTree.left);
                    } else if (qTree.left != null || pTree.left != null) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (bfs.size() % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}
