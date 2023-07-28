class Solution {
    public boolean detectCapitalUse(String word) {
        
        char[] chars = word.toCharArray();
        boolean capital = false;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                if (i == 0) {
                    capital = true;
                }
                count++;
            }
        }
        if (count == 1 && capital) {
            return true;
        }
        if (count == chars.length || count == 0) {
            return true;
        }
        return false;
    }
}