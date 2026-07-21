class Solution {

    public String encode(List<String> strs) {
            StringBuilder encoded = new StringBuilder();

            for (String str : strs) {
                encoded.append(str.length() + "#");
                for (int i = 0; i < str.length(); i++) {
                    char cipherChar = (char) str.charAt(i);
                    encoded.append(cipherChar);
                }
            }

            return encoded.toString();
        }

        public List<String> decode(String str) {
            List<String> answer = new ArrayList<>();

            int i = 0;
            while (i < str.length()) {
                int j = i;
                while (str.charAt(j) != '#') j++;
                
                StringBuilder decoded = new StringBuilder();
                int length = Integer.parseInt(str.substring(i, j));

                for (int k = j + 1; k < j + length + 1; k++) {
                    decoded.append(str.charAt(k));
                }

                answer.add(decoded.toString());
                i = j + length + 1;
                
            }

            return answer;
        }
}
