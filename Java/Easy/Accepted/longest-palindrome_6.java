class Solution {
    public int longestPalindrome(String s) {
        
        int[] freq = new int[128];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        int result = 0;
        for (int i = 0; i < 128; i++) {
            result += (freq[i] / 2) * 2;
            if (result % 2 == 0 && freq[i] % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}