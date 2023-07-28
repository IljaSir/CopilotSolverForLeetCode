class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        int n = nums.size();
        vector<long long> ans(n);
        vector<long long> pre(n + 1);
        vector<bool> rm(n);
        for (int i = 0; i < n; ++i) {
            pre[i + 1] = pre[i] + nums[i];
        }
        for (int i = n - 1; i >= 0; --i) {
            int idx = removeQueries[i];
            rm[idx] = true;
            long long sum = 0;
            if (idx > 0 && !rm[idx - 1]) {
                sum += pre[idx] - pre[0];
            }
            if (idx < n - 1 && !rm[idx + 1]) {
                sum += pre[n] - pre[idx + 1];
            }
            ans[i] = sum;
        }
        return ans;
    }
};