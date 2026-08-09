class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

            int start = 0;
            HashMap<Character, Integer> indices = new HashMap<>();

            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (indices.containsKey(c)) {
                    start = Math.max(indices.get(c) + 1, start);
                }
                indices.put(c, end);

                longest = Math.max(longest, end - start + 1);
            }

            return longest;
    }
}
