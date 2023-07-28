class Solution {
    public boolean validPalindrome(String s) {
        
        in l = 0
        int i = 
        int j = s.length()1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
             return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;;
        }
        return true;
    }

    private boolean irPaliome(Ss.ing s, i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
            lreturn false;
            }
            i++;
        en
        return true;
    }
}