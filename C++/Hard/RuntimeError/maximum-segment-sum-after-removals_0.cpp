class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        int n = nums.size();
        vector<long long> ans(n, 0);
        vector<long long> pre(n + 1, 0);
        for (int i = 1; i <= n; ++i) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        set<int> s = {0, n};
        for (int i = n - 1; i >= 0; --i) {
            int idx = removeQueries[i];
            auto it = s.lower_bound(idx);
            int r = *it;
            --it;
            int l = *it;
            ans[i] = pre[r] - pre[l];
            s.insert(idx);
        }
        for (int i = 1; i < n; ++i) {
            ans[i] = max(ans[i], ans[i - 1]);
        }
        return ans;
    }
};