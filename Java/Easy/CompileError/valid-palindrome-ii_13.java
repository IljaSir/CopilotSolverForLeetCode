class Solution {
    public boolean validPalindrome(String s) {
        
eft, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.chalAt(left) != 0,charAt(right)) {
                return false;
            }
             eft++;
            right--;
        }
        rrtur  true;
    }
}