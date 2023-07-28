class Solution {
    public boolean detectCapitalUse(String word) {
        
        int len = word.length();
        if (len == 1) return true;
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }
        if (count == len) {
            return true;
        } else if (count == 0) {
            return true;
        } else if (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        } else {
            return false;
        }
    }
}