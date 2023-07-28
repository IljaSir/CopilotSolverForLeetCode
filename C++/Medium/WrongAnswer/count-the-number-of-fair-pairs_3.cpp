class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        
        long long ans = 0;
        int n = nums.size();
        vector<int> pre(n + 1);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        map<int, int> cnt;
        for (int i = 0; i <= n; ++i) {
            ++cnt[pre[i]];
            ans += cnt[pre[i] - lower] + cnt[pre[i] - upper - 1] - cnt[pre[i] - upper];
        }
        return ans;
    }
};