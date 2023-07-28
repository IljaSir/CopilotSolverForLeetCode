class Solution {
    public String breakPalindrome(String palindrome) {
        
        int len = palindrome.length();
        if (len <= 1) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[len - 1] = 'b';
        return new String(chars);
    }
}