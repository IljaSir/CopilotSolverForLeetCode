class Solution {
public:
    int numSub(string s) {
        
        int cnt = 0;
        int ans = 0;
        int mod = 1e9+7;
        for (char c : s) {
            if (c == '1') {
                cnt++;
            } else {
                ans += (cnt * (cnt + 1) / 2) % mod;
                ans %= mod;
                cnt = 0;
            }
        }
        ans += (cnt * (cnt + 1) / 2) % mod;
        ans %= mod;
        return ans;
    }
};