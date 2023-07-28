class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] result = new int[queryCharacters.length()];
        int[] count = new int[26];
        int max = 0;
        for (int i = 0; i < queryCharacters.length(); i++) {
            int index = queryIndices[i];
            char c = s.charAt(index);
            char query = queryCharacters.charAt(i);
            count[c - 'a']--;
            count[query - 'a']++;
            max = Math.max(max, count[query - 'a']);
            result[i] = max;
        }
        return result;
    }
}