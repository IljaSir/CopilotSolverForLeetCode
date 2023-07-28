class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int start = 0, end = 0, maxCount = 0, maxLength = 0;
        while (end < s.length()) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start++) - 'A']--;
            }
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }
}