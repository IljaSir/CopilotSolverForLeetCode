class Solution {
    public String breakPalindrome(String palindrome) {
        
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        chars[n - 1] = 'b';
        return String.valueOf(chars);
    }
}