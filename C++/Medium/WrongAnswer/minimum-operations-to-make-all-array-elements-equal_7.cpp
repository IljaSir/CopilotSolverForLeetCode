class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        long long n = nums.size();
        long long m = queries.size();
        vector<long long> res(m, 0);
        vector<long long> cnt(100001, 0);
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        vector<long long> sum(100001, 0);
        for (int i = 1; i <= 100000; i++) {
            sum[i] = sum[i - 1] + cnt[i];
        }
        for (int i = 0; i < m; i++) {
            int x = queries[i];
            int l = 1;
            int r = 100000;
            int pos = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (mid > x) {
                    r = mid - 1;
                } else {
                    pos = mid;
                    l = mid + 1;
                }
            }
            res[i] += sum[pos] * x - sum[1] + sum[100000] - sum[pos];
        }
        return res;
    }
};