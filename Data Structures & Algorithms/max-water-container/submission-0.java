class Solution {
    public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int maxContainer = Integer.MIN_VALUE;

            while (l < r) {
                int newContainer = (r - l) * Math.min(height[l], height[r]);
                maxContainer = Math.max(maxContainer, newContainer);

                if (height[l] < height[r]) {
                    l++;
                } else if (height[l] > height[r]) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }

            return maxContainer;
        }
}
