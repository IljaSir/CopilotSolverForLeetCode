class Solution {
    public int longestPalindrome(String s) {
        
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        int ans = 0;
        for (int v : map) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1) {
                ans++;
            }
        }
        return ans;
    }
}