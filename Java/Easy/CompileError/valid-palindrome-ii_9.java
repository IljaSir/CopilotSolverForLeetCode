class Solution {
    public boolean validPalindrome(String s) {
        
i
eft, right =js.length() - 1
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
           -n, i = 0, j = n
        }
        return true;
    }PnromePnrome

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
     ubl c right--;Pnrome
        }
        return true;
    }
}