class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(31, 0);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        int mod = 1e9 + 7;
        int res = 0;
        for (int i = 1; i < 1 << 30; ++i) {
            int prod = 1;
            int num = 0;
            for (int j = 0; j < 30; ++j) {
                if (i & (1 << j)) {
                    prod *= j + 1;
                    num += cnt[j + 1];
                }
            }
            if (prod > 30) {
                continue;
            }
            int tmp = 1;
            for (int j = 0; j < cnt[prod]; ++j) {
                tmp *= 2;
                tmp %= mod;
            }
            if (num % 2 == 0) {
                res -= tmp;
            } else {
                res += tmp;
            }
            res = (res + mod) % mod;
        }
        return res;
    }
};