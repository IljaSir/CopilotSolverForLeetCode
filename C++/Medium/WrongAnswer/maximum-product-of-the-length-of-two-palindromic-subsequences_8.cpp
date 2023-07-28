class Solution {
public:
    int maxProduct(string s) {
        
        int n = s.size();
        vector<int> dp(1 << n, 0);
        for (int i = 0; i < (1 << n); i++) {
            int l = 0;
            int r = n - 1;
            while (l < r) {
                while (l < r && !(i & (1 << l))) l++;
                while (l < r && !(i & (1 << r))) r--;
                if (s[l] != s[r]) break;
                l++;
                r--;
            }
            if (l >= r) dp[i] = __builtin_popcount(i);
        }
        int result = 0;
        for (int i = 0; i < (1 << n); i++) {
            result = max(result, dp[i] * dp[((1 << n) - 1) ^ i]);
        }
        return result;
    }
};