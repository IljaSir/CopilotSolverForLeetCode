class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int result = 0;
        for (String word : words) {
            if (isSubsequence(word, s)) {
                result++;
            }
        }
        return result;
    }
    private boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
}