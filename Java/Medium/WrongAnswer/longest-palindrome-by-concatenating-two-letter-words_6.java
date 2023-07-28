class Solution {
    public int longestPalindrome(String[] words) {
        
        int[] count = new int[26];
        for (String word : words) {
            count[word.charAt(0) - 'a']++;
            count[word.charAt(1) - 'a']++;
        }
        int result = 0;
        for (int c : count) {
            result += c / 2 * 2;
        }
        return result < words.length ? result + 1 : result;
    }
}