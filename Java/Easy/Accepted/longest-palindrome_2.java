class Solution {
    public int longestPalindrome(String s) {
        
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}