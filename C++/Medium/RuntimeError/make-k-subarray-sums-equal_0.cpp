class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<long long> sum(n+1, 0);
        for (int i = 0; i < n; ++i) {
            sum[i+1] = sum[i] + arr[i];
        }
        long long ans = 1e18;
        for (int i = 0; i < n; ++i) {
            long long res = 0;
            for (int j = 0; j < k; ++j) {
                int l = i + j;
                int r = i + j + n;
                long long cur = sum[r] - sum[r-k];
                long long expect = sum[l] - sum[l-k];
                res += abs(cur - expect);
            }
            ans = min(ans, res);
        }
        return ans;
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        if (k == n) {
            return 0;
        }
        long long total = 0;
        for (int i = 0; i < n; ++i) {
            total += arr[i];
        }
        long long expect = total * k / n;
        for (int i = 0; i < n; ++i) {
            arr[i] = arr[i] * k - expect;
        }
        return makeSubKSumEqual(arr, k);
    }
};