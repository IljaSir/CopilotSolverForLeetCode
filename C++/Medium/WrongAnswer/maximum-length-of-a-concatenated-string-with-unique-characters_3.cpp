class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        vector<int> dp(1, 0);
        int res = 0;
        for (auto& s : arr) {
            int mask = 0, dup = 0;
            for (auto& c : s) {
                mask |= 1 << (c - 'a');
                if (mask & (1 << (c - 'a')) & dup) break;
                dup |= 1 << (c - 'a');
            }
            if (mask != dup) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if (dp[i] & mask) continue;
                dp.push_back(dp[i] | mask);
                res = max(res, __builtin_popcount(dp.back()));
            }
        }
        return res;
    }
};