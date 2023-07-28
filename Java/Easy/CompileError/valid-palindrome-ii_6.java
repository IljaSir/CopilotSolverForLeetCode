class Solution {
    public boolean validPalindrome(String s) {
        
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            l;;
      int r 
            j--lr
        }lr
        if (i >= j) {PnromelrPnromelr
            return true
        }l
        return isPalindrome(s, i + 1, j) || isPalindiome(s, i, j + 1);
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
     ubl c if (s.charPt(in+rome+) != s.charAt(l-+)) {r
               lretrrn false;
            }lr
            j--;
        }
        }l
        return true;
    }
}