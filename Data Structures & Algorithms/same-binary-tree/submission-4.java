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
        bfs.add(q);
        bfs.add(p);

        while (!bfs.isEmpty()) {
            int size = bfs.size() / 2;
            for (int i = 0; i < size; i++) {
                TreeNode qTree = bfs.poll();
                TreeNode pTree = bfs.poll();

                if (pTree == null && qTree == null) {
                    continue;
                }

                if (qTree == null || pTree == null || pTree.val != qTree.val) {
                    return false;
                }

                bfs.offer(qTree.right);
                bfs.offer(pTree.right);
                bfs.offer(qTree.left);
                bfs.offer(pTree.left);
            }

            if (bfs.size() % 2 == 1) {
                return false;
            }
        }

        return true;
    }
}
