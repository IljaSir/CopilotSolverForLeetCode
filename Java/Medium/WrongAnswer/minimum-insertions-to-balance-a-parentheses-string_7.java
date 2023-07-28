class Solution {
    public int minInsertions(String s) {
        
        int open = 0;
        int close = 0;
        int insertions = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (close > open) {
                insertions++;
                open++;
            }
            if (close == open) {
                close = 0;
                open = 0;
            }
        }
        return insertions + 2 * open;
    }
}