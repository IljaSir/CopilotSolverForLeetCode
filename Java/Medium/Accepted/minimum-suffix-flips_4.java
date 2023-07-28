class Solution {
    public int minFlips(String target) {
        
        int n = target.length();
        int ans = 0;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (target.charAt(i) - '0' != prev) {
                ans++;
                prev = 1 - prev;
            }
        }
        return ans;
    }
}