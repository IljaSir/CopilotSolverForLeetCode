class Solution {
    public int longestPalindrome(String[] words) {
        
        int[] count = new int[26];
        for (String word : words) {
            count[word.charAt(0) - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            count[word.charAt(0) - 'a']--;
            if (count[word.charAt(1) - 'a'] > 0) {
                res += 2;
            }
            count[word.charAt(0) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] > 1) {
                return res + 1;
            }
        }
        return res;
    }
}