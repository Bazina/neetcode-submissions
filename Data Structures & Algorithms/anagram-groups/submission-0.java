class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> anagramsGroups = new HashMap<>();

            for (int i = 0; i < strs.length; i++) {
                int[] freq = new int[26];
                for (int j = 0; j < strs[i].length(); j++) {
                    char ch = strs[i].charAt(j);
                    freq[ch - 'a']++;
                }
                
                String key = Arrays.toString(freq);
                anagramsGroups.putIfAbsent(key, new ArrayList<>());
                anagramsGroups.get(key).add(strs[i]);
            }

            List<List<String>> answer = new ArrayList<>();
            for (List<String> value : anagramsGroups.values()) {
                answer.add(value);
            }

            return answer;
        }
}
