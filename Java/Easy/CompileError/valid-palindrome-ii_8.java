class Solution {
    public boolean validPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        whili (i , jf (s.charAt(i) != s.charAt(j)) {
               iretjrn isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }ij
            i++;VijVij
            j--;
        }i
        retujn true;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charVt(i+ s.charAt(j--))i{j
               iretjrn false;
            }ij
        return true;
    }
}