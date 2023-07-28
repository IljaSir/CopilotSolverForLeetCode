class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size(), m = queries.size();
        vector<long long> pre(n + 1);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        vector<int> cnt(100001);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        vector<long long> ans(m);
        for (int i = 0; i < m; ++i) {
            int x = queries[i];
            for (int j = 1; j * j <= x; ++j) {
                if (x % j == 0) {
                    ans[i] += 1LL * j * cnt[j];
                    if (j * j != x) {
                        ans[i] += 1LL * (x / j) * cnt[x / j];
                    }
                }
            }
            ans[i] -= pre[upper_bound(nums.begin(), nums.end(), x) - nums.begin()];
        }
        return ans;
    }
};