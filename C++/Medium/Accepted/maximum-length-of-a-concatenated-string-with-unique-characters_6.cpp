class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        int n = arr.size();
        vector<int> dp(1, 0);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int mask = 0, dup = 0;
            for (char ch : arr[i]) {
                int bit = ch - 'a';
                if (mask >> bit & 1) {
                    dup = 1;
                    break;
                }
                mask |= 1 << bit;
            }
            if (dup) continue;
            int m = dp.size();
            for (int j = 0; j < m; j++) {
                if (dp[j] & mask) continue;
                dp.push_back(dp[j] | mask);
                ans = max(ans, __builtin_popcount(dp.back()));
            }
        }
        return ans;
    }
};