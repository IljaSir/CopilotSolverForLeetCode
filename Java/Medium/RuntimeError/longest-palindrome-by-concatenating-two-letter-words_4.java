class Solution {
    public int longestPalindrome(String[] words) {
        
        int n = words.length;
        int[] mask = new int[n];
        for (int i = 0; i < n; i++) {
            mask[i] = 0;
            for (int j = 0; j < 2; j++) {
                mask[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
        int[] count = new int[1 << 10];
        for (int i = 0; i < n; i++) {
            count[mask[i]]++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << 10); j++) {
                if ((mask[i] & j) == 0) {
                    ans = Math.max(ans, count[j] * 2 + count[mask[i] | j]);
                }
            }
        }
        return ans;
    }
}