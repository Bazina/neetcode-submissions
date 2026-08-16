class Solution {
    public String minWindow(String s, String t) {
            int minWindow = Integer.MAX_VALUE;
            int minLeft = -1, minRight = -1;

            int[] frequencyMap = new int[200];
            HashSet<Character> tCharacters = new HashSet<>();
            for (int i = 0; i < t.length(); i++) {
                frequencyMap[t.charAt(i) - 'A']++;
                tCharacters.add(t.charAt(i));
            }

            int tLength = t.length();
            int total = tLength;
            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);
                boolean isFound = tCharacters.contains(c);

                while (right > left && !tCharacters.contains(s.charAt(left))) {
                    left++;
                }

                if (isFound) {
                    frequencyMap[c - 'A']--;
                    if (frequencyMap[c - 'A'] >= 0) {
                        total--;
                    }

                    while (total == 0 || (left < s.length() && !tCharacters.contains(s.charAt(left)))) {
                        if (total == 0 && right - left + 1 < minWindow) {
                            minWindow = right - left + 1;
                            minLeft = left;
                            minRight = right;
                        }

                        char leftChar = s.charAt(left++);
                        if (tCharacters.contains(leftChar)) {
                            frequencyMap[leftChar - 'A']++;
                            if (frequencyMap[leftChar - 'A'] > 0) {
                                total++;
                            }
                        }
                    }
                }
            }

            return minWindow != Integer.MAX_VALUE ? s.substring(minLeft, minRight + 1) : "";
        }
}
