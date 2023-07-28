class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] res = new int[queryCharacters.length()];
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < queryCharacters.length(); i++) {
            int index = queryIndices[i];
            chars[s.charAt(index) - 'a']--;
            res[i] = chars[queryCharacters.charAt(i) - 'a'];
            chars[s.charAt(index) - 'a']++;
        }
        return res;
    }
}