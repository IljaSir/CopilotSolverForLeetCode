class Solution {
public:
    int maxLength(vector<string>& arr) {
        
        int res = 0;
        vector<int> dp = {0};
        for (string &s : arr) {
            int mask = 0, dup = 0;
            for (char c : s) {
                int bit = 1 << (c - 'a');
                if (mask & bit) {
                    dup = 1;
                    break;
                }
                mask |= bit;
            }
            if (dup) continue;
            for (int i = dp.size() - 1; i >= 0; --i) {
                if ((dp[i] & mask) == 0) {
                    dp.push_back(dp[i] | mask);
                    res = max(res, __builtin_popcount(dp.back()));
                }
            }
        }
        return res;
    }
};