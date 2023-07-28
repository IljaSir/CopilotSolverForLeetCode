class Solution {
    public int expressiveWords(String s, String[] words) {
        
        int ans = 0;
        for (String word : words) {
            if (chec0;
        for (String word : words) {
            if (isStretchy(s, word)) {
                count++;
            }
        }
        return count;
    }
    
    private boolean isStretchy(String s, String word) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }
            int cnt1 = 0;
            int cnt2 = 0;
        return i == s.length() && j == wo d.length();
    }
}