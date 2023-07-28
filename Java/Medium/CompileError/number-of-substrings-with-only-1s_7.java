class Solution {
    public int numSub(String s) {
        
        int count = 0;
        int ans = 0;
        int MOD = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                ans = (ans + (count * (count + 1L) / 2)) % MOD;
                count = 0;
            }
        }
        ans = (ans + (count * (count + 1L) / 2)) % MOD;
        return ans;
    }
}