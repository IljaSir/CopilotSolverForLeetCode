class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        
        int count = 0;
        for (String word : words) {
            if (isSubsequence(word, s)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isSubsequence(String word, String s) {
        int i = 0;
        for (char c : s.toCharArray()) {
            if (i < word.length() && c == word.charAt(i)) {
                i++;
            }
        }
        return i == word.length();
    }
}