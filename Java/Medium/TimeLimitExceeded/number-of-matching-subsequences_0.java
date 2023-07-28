class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (isSubsequence(s, word)) {
                count++;
            }
        }
        return count;
    }
    private boolean isSubsequence(String s, String word) {
        int i = 0, j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == word.length();
    }
}