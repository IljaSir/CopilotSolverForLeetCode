class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;
            } else {
                freq[c - 'A' + 26]++;
            }
        }
        int result = 0;
        boolean hasOdd = false;
        for (int i = 0; i < 52; i++) {
            if (freq[i] % 2 == 0) {
                result += freq[i];
            } else {
                hasOdd = true;
                result += freq[i] - 1;
            }
        }
        return hasOdd ? result + 1 : result;
    }
}