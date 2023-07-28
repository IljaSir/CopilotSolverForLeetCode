class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        vector<int> cnt(100001, 0);
        for (int i = 0; i < n; ++i) {
            ++cnt[nums[i]];
        }
        vector<long long> sum(100001, 0);
        for (int i = 1; i <= 100000; ++i) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        vector<long long> ans;
        for (int i = 0; i < queries.size(); ++i) {
            int q = queries[i];
            int l = 1, r = 100000;
            while (l < r) {
                int m = (l + r) / 2;
                if (m >= q) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            long long res = (sum[100000] - sum[l - 1]) * (q - l + 1);
            l = 1, r = 100000;
            while (l < r) {
                int m = (l + r + 1) / 2;
                if (m <= q) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            res += (sum[l] - sum[0]) * (l - q + 1);
            ans.push_back(res);
        }
        return ans;
    }
};