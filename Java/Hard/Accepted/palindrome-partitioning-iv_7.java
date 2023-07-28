class Solution {
    public boolean checkPartitioning(String s) {
        
        int len = s.length();
        boolean[][] isPalindrome = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < len - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j + i < len; j++) {
                isPalindrome[j][j + i] = isPalindrome[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
            }
        }
        for (int i = 0; i < len - 2; i++) {
            if (isPalindrome[0][i]) {
                for (int j = i + 1; j < len - 1; j++) {
                    if (isPalindrome[i + 1][j] && isPalindrome[j + 1][len - 1]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}