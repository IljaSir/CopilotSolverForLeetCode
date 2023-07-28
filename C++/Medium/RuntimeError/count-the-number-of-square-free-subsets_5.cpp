class Solution {
public:
    int squareFreeSubsets(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> cnt(31);
        for (auto x : nums) {
            cnt[x]++;
        }
        int ans = 0;
        for (int mask = 1; mask < (1 << 30); mask++) {
            int prod = 1;
            int sign = 1;
            for (int i = 1; i <= 30; i++) {
                if ((mask >> (i - 1)) & 1) {
                    prod *= i;
                    sign *= -1;
                }
            }
            if (prod <= 30) {
                ans += sign * cnt[prod];
            }
        }
        return ans;
    }
};