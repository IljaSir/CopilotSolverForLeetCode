class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int n = arr.size();
        int mod = 1e9 + 7;
        long long sum = 0, max_sum = 0, max_sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + arr[i]) % mod;
            max_sum = max(max_sum, sum);
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum = (sum + arr[i]) % mod;
            max_sum2 = max(max_sum2, sum);
        }
        if (k == 1) return max_sum;
        long long ans = max(max_sum, max_sum2);
        ans = max(ans, max_sum + max_sum2);
        if (k > 2) {
            sum = 0;
            for (int i = 0; i < n; i++) {
                sum = (sum + arr[i]) % mod;
            }
            ans = max(ans, max_sum + max_sum2 + sum * (k - 2));
        }
        return ans;
    }
};