class Solution {
    public int[] twoSum(int[] numbers, int target) {
            int l = 0, r = numbers.length - 1;
            while (l < r) {
                int currentLeft = numbers[l], currentRight = numbers[r];
                if (target < currentLeft + currentRight) {
                    r--;
                } else if (target > currentLeft + currentRight) {
                    l++;
                } else {
                    return new int[] { l + 1, r + 1 };
                }
            }

            return new int[] { -1, -1 };
        }
}
