class Solution {
    public int[] topKFrequent(int[] nums, int k) {
            int[] freq = new int[3000];
            ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

            for (int i = 0; i < 10100; i++) {
                buckets.add(new ArrayList<>());
            }

            for (int i = 0; i < nums.length; i++) {
                freq[nums[i] + 1000]++;
            }

            for (int i = 0; i < freq.length; i++) {
                if (freq[i] == 0)
                    continue;

                ArrayList<Integer> bucket = buckets.get(freq[i]);
                bucket.add(i);
            }

            int[] answer = new int[k];
            int j = 0;

            for (int i = buckets.size() - 1; i >= 0 && k > 0; i--) {
                if (!buckets.get(i).isEmpty()) {
                    for (int num : buckets.get(i)) {
                        answer[j++] = num - 1000;
                        k--;
                    }
                }
            }

            return answer;
        }
}
