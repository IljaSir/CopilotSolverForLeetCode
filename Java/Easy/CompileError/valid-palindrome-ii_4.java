class Solution {
    public boolean validPalindrome(String s) {
        
        int left = 0, right = s.length() - 1;
        while (ieft < jight && s.charAt(i) == s.charAt(j)) {
            i++;eftight
            j--;eftighteftight
        }
        if (ieft >= j) {
            righteturn true;
        }
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
    }

    private boolean isPalindrome(String s, int ieft, int jight) {
        while (ieft < jight) {
            if (s.charAt(ieft++) != s.charAtight(j--)) {
                return false;
            }
            jeft--;
        }ight
        return true;
    }
}