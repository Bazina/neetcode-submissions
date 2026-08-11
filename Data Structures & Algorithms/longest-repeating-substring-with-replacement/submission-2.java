class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;

            HashMap<Character, Integer> freq = new HashMap<>();
            int mostFrequent = 0;

            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                freq.put(c, freq.getOrDefault(c, 0) + 1);

                mostFrequent = Math.max(mostFrequent, freq.get(c));

                int windowLength = r - l + 1;
                int numberOfReplacements = k - (windowLength - mostFrequent);

                if (numberOfReplacements >= 0) {
                    longest = Math.max(longest, windowLength);
                } else {
                    c = s.charAt(l++);
                    freq.put(c, freq.get(c) - 1);
                }
            }

            return longest;
    }
}
