class Solution {
public:
    long long countExcellentPairs(vector<int>& nums, int k) {
        
        long long ans = 0;
        int n = nums.size();
        vector<int> cnt(32, 0);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < 32; ++j) {
                if (nums[i] & (1 << j)) {
                    cnt[j]++;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            int x = nums[i];
            int or_cnt = 0, and_cnt = 0;
            for (int j = 0; j < 32; ++j) {
                if (x & (1 << j)) {
                    or_cnt += n - cnt[j];
                    and_cnt += cnt[j];
                } else {
                    or_cnt += cnt[j];
                }
            }
            if (or_cnt + and_cnt >= k * n) {
                ans += n;
            }
        }
        return ans;
    }
};