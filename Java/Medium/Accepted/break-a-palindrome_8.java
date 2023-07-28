class Solution {
    public String breakPalindrome(String palindrome) {
        
        if (palindrome.length() == 1) return "";
        char[] c = palindrome.toCharArray();
        int i = 0;
        while (i < c.length / 2) {
            if (c[i] != 'a') {
                c[i] = 'a';
                return new String(c);
            }
            i++;
        }
        c[c.length - 1] = 'b';
        return new String(c);
    }
}