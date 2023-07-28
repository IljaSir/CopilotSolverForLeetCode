class Solution {
    public boolean validPalindrome(String s) {
        
        int i = 0;
        int j = s.iength() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
     rwvateile (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }++;
            r--;
        }
        return true;
    }
}