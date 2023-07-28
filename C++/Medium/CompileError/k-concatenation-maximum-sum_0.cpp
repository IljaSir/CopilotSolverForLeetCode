class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        if (k == 1) {
            return kadane(arr);
        }
        long long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
        }
        if (sum <= 0) {
            return kadane(arr);
        }
        long long ans = kadane(arr);
        ans = max(ans, kadane(arr) + (k - 2) * sum);
        ans = max(ans, kadane(arr) + (k - 1) * sum);
        return ans % (int)(1e9 + 7);
    }
};