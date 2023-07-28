class Solution {
    public String breakPalindrome(String palindrome) {
        
        int len = palindrome.length();
        if (len == 1) return "";
        char[] arr = palindrome.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] != 'a') {
                arr[i] = 'a';
                return String.valueOf(arr);
            }
        }
        arr[len - 1] = 'b';
        return String.valueOf(arr);
    }
}