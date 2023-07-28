class Solution {
    public int longestPalindrome(String s) {
        
        int[] charCount = new int[58];
        int result = 0;
        for (char c : s.toCharArray()) {
            charCount[c - 'A']++;
        }
        for (int count : charCount) {
            result += count / 2 * 2;
            if (result % 2 == 0 && count % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}