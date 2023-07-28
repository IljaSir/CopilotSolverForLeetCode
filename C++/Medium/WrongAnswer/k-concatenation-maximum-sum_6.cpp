class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        int maxElement = INT_MIN;
        int totalSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            totalSum += arr[i];
            maxElement = max(maxElement, arr[i]);
            sum += arr[i];
            maxSum = max(maxSum, sum);
            minSum = min(minSum, sum);
        }
        if (k == 1) {
            return maxSum;
        }
        if (totalSum < 0) {
            return maxSum;
        }
        if (maxElement < 0) {
            return 0;
        }
        return (maxSum - minSum + totalSum * (k - 2)) % 1000000007;
    }
};