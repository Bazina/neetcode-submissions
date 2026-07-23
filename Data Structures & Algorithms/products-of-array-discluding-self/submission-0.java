class Solution {
    public int[] productExceptSelf(int[] nums) {
            int[] suffix = new int[nums.length];
            int[] prefix = new int[nums.length];

            prefix[0] = 1;
            suffix[nums.length - 1] = 1;

            for (int i = 1, j = nums.length - 2; i < nums.length; i++, j--) {
                prefix[i] = prefix[i - 1] * nums[i - 1];
                suffix[j] = suffix[j + 1] * nums[j + 1];
            }

            int[] answer = new int[nums.length];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = prefix[i] * suffix[i];
            }

            return answer;
        }
}  
