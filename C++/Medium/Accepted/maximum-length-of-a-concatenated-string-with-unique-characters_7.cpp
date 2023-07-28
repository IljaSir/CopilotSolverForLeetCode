class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        vector<int> dp{0};
        int ans = 0;
        for (auto &s : arr) {
            int mask = 0;
            for (auto &c : s) {
                int bit = 1 << (c - 'a');
                if (mask & bit) {
                    mask = 0;
                    break;
                }
                mask |= bit;
            }
            if (mask == 0) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if (dp[i] & mask) continue;
                dp.push_back(dp[i] | mask);
                ans = max(ans, __builtin_popcount(dp.back()));
            }
        }
        return ans;
    }
};