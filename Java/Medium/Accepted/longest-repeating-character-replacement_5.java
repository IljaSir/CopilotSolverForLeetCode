class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int maxCount = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);
            right++;
            if (right - left > maxCount + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}