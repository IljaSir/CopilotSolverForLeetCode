class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<long long> sum(n, 0);
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + k - 1) % n;
            long long cur = sum[j] - (i == 0 ? 0 : sum[i - 1]);
            ans = max(ans, cur);
        }
        return ans;
    }
    long long makeEqual(vector<int>& arr) {
        int n = arr.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % n != 0) {
            return -1;
        }
        long long avg = sum / n;
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            arr[i] -= avg;
        }
        for (int k = 1; k < n; k++) {
            if (n % k == 0) {
                ans = max(ans, makeSubKSumEqual(arr, k));
            }
        }
        return ans;
    }
};