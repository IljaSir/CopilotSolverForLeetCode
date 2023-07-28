class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<long long> cnt(100001, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<long long> pre(100001, 0);
        for (int i = 1; i <= 100000; i++) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        vector<long long> ans(m, 0);
        for (int i = 0; i < m; i++) {
            long long x = queries[i];
            int l = 1, r = 100000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (pre[mid] * mid < x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int a = l;
            l = 1, r = 100000;
            while (l < r) {
                int mid = (l + r) / 2;
                if (pre[mid] * mid <= x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int b = l;
            if (a > b) {
                swap(a, b);
            }
            ans[i] = pre[a - 1] * (a - 1) + (x - pre[a - 1] * a) + (pre[b - 1] * b - pre[a - 1] * a) + (pre[100000] - pre[b - 1]) * b - (pre[b - 1] - pre[a - 1]) * x;
        }
        return ans;
    }
};