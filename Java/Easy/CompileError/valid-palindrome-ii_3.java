class Solution {
    public boolean validPalindrome(String s) {
        
 i = 0, j =s.ength() - 1;
       while (i < j && s.charAt(i) = s.charAt(j)) {
            i++;
            j--;
        }
        if (i >= j) {
           return true;
        }
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.chaiAt(i++) != 0,charAt(j--)) {
                return fa sj;
            }
        }
        retur  true;
    }
}