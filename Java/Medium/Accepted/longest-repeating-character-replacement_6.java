class Solution {
    public int characterReplacement(String s, int k) {
        
        int max = 0;
        int[] count = new int[26];
        int start = 0, end = 0;
        while (end < s.length()) {
            count[s.charAt(end) - 'A']++;
            max = Math.max(max, count[s.charAt(end) - 'A']);
            if (end - start + 1 - max > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            end++;
        }
        return end - start;
    }
}