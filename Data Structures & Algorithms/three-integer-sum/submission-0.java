class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> answerSet = new HashSet<>();
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);

            int n = nums.length;
            int i = 0, l = 0, r = n - 1;

            while (i < n) {
                int target = nums[i] * -1;
                l = i + 1;
                r = n - 1;

                while (l < r) {
                    int currentLeft = nums[l];
                    int currentRight = nums[r];

                    if (target < currentLeft + currentRight) {
                        r--;
                    } else if (target > currentLeft + currentRight) {
                        l++;
                    } else {
                        answerSet.add(new ArrayList<>(List.of(target * -1, currentLeft, currentRight)));
                        l++;
                        r--;
                    }
                }
                i++;
            }

            for (List<Integer> list : answerSet) {
                answer.add(list);
            }

            return answer;
        }
}
