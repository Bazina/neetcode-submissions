class Solution {
    public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> restOfSumToIndex = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int currentNum = nums[i];

                if (restOfSumToIndex.containsKey(currentNum)) {
                    int j = restOfSumToIndex.get(currentNum);
                    return new int[]{j, i};
                }

                restOfSumToIndex.put(target - currentNum, i);
            }

            return new int[]{-1, -1};
        }
}
