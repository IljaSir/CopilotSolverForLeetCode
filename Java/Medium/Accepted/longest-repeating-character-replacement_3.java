class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            max = Math.max(max, ++count[s.charAt(right) - 'A']);
            if (right - left + 1 - max > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
        }
        return s.length() - left;
    }
}