class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

            int start = 0;
            int[] freq = new int[126];

            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                freq[c - ' ']++;

                if (freq[c - ' '] <= 1) {
                    longest = Math.max(longest, end - start + 1);
                }

                while (freq[c - ' '] > 1 && start < end) {
                    char remove = s.charAt(start++);
                    freq[remove - ' ']--;
                }
            }

            return longest;
    }
}
