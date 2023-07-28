class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int n = arr.size();
        long long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum < 0 || k == 1) {
            return maxSubArray(arr) % 1000000007;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        ans = ans * (k - 2);
        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        for (int i = 0; i < n; i++) {
            ans += arr[i];
        }
        return ans % 1000000007;
    }
};