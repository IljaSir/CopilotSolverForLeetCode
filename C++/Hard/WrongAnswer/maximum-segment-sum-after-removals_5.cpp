class Solution {
public:
    vector<long long> maximumSegmentSum(vector<int>& nums, vector<int>& removeQueries) {
        
        int n = nums.size();
        vector<long long> ans(n);
        vector<bool> deleted(n, false);
        vector<long long> prefix(n + 1);
        for (int i = 0; i < n; ++i) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        vector<long long> suffix(n + 1);
        for (int i = n - 1; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + nums[i];
        }
        vector<int> q(n);
        iota(q.begin(), q.end(), 0);
        sort(q.begin(), q.end(), [&](int i, int j) {
            return removeQueries[i] > removeQueries[j];
        });
        int i = 0;
        int j = 0;
        long long max = 0;
        while (i < n) {
            while (j < n && removeQueries[q[j]] == removeQueries[q[i]]) {
                deleted[removeQueries[q[j]]] = true;
                ++j;
            }
            long long sum = 0;
            int l = -1;
            int r = -1;
            for (int k = 0; k < n; ++k) {
                if (deleted[k]) {
                    if (l != -1) {
                        sum += suffix[l] - suffix[r + 1];
                        if (sum > max) {
                            max = sum;
                        }
                    }
                    l = -1;
                    r = -1;
                    sum = 0;
                } else {
                    if (l == -1) {
                        l = k;
                    }
                    r = k;
                }
            }
            if (l != -1) {
                sum += suffix[l] - suffix[r + 1];
                if (sum > max) {
                    max = sum;
                }
            }
            while (i < j) {
                ans[q[i]] = max;
                ++i;
            }
        }
        return ans;
    }
};