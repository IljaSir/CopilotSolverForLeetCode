class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int mod = 1e9 + 7;
        int n = arr.size();
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        int totalSum = 0;
        for (int i = 0; i < n; ++i) {
            totalSum += arr[i];
            sum += arr[i];
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        if (k == 1) {
            return maxSum;
        }
        int ans = 0;
        if (totalSum > 0) {
            ans = maxSum + totalSum * (k - 2) + max(0, minSum);
        } else {
            ans = maxSum + totalSum * (k - 2);
        }
        return ans % mod;
    }
};