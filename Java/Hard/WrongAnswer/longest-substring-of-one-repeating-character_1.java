class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        
        int[] res = new int[queryCharacters.length()];
        for (int i = 0; i < queryCharacters.length(); i++) {
            res[i] = longestRepeating(s, queryCharacters.charAt(i), queryIndices[i]);
        }
        return res;
    }
    private int longestRepeating(String s, char c, int index) {
        int res = 0;
        int i = index, j = index;
        while (i >= 0 && s.charAt(i) == c) {
            i--;
        }
        while (j < s.length() && s.charAt(j) == c) {
            j++;
        }
        res = j - i - 1;
        return res;
    }
}