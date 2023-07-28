class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] ans = new int[queryCharacters.length()];
        int[] last = new int[26];
        int[] len = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            len[c] = i - last[c] + 1;
            last[c] = i + 1;
        }
        for (int i = 0; i < queryCharacters.length(); i++) {
            int c = queryCharacters.charAt(i) - 'a';
            ans[i] = len[c];
            len[c] = Math.max(len[c], queryIndices[i] - last[c] + 1);
            last[c] = queryIndices[i] + 1;
        }
        return ans;
    }
}