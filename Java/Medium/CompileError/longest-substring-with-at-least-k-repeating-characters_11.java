class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int split = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && count[i] < k) {
                split = i;
                break;
            }ight);
    }
}