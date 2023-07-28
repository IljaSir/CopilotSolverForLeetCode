class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] res = new int[queryCharacters.length()];
        int[] charCount = new int[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            max = Math.max(max, charCount[s.charAt(i) - 'a']);
            for (int j = 0; j < queryCharacters.length(); j++) {
                if (queryIndices[j] == i) {
                    if (charCount[queryCharacters.charAt(j) - 'a'] == 0) {
                        res[j] = 0;
                    } else {
                        res[j] = max;
                    }
                }
            }
        }
        return res;
    }
}