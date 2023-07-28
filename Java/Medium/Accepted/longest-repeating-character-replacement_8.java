class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] freq = new int[26];
        int max = 0, left = 0, right = 0;
        while (right < s.length()) {
            max = Math.max(max, ++freq[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                freq[s.charAt(left++) - 'A']--;
            }
            right++;
        }
        return right - left;
    }
}