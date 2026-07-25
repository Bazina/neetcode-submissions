class Solution {
    public int longestConsecutive(int[] nums) {
            HashMap<Integer, Integer> parents = new HashMap<>();
            HashMap<Integer, Integer> sizes = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                parents.put(nums[i], nums[i]);
                sizes.put(nums[i], 1);
            }

            for (int i = 0; i < nums.length; i++) {
                if (parents.containsKey(nums[i] - 1)) {
                    union(nums[i], nums[i] - 1, parents, sizes);
                }
            }

            int max = 0;
            for (int size : sizes.values()) {
                max = Math.max(size, max);
            }

            return max;
        }

        private int find(int v, HashMap<Integer, Integer> parents) {
            if (v == parents.get(v)) {
                return v;
            }

            return find(parents.get(v), parents);
        }

        private void union(int a, int b, HashMap<Integer, Integer> parents, HashMap<Integer, Integer> sizes) {
            int aParent = find(a, parents);
            int bParent = find(b, parents);

            if (aParent != bParent) {
                if (sizes.get(aParent) < sizes.get(bParent)) {
                    parents.put(aParent, bParent);
                    sizes.put(bParent, sizes.get(aParent) + sizes.get(bParent));
                } else {
                    parents.put(bParent, aParent);
                    sizes.put(aParent, sizes.get(aParent) + sizes.get(bParent));
                }
            }
        }
}
