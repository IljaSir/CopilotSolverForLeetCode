class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        if (k == 1) {
            return maxSubArray(arr);
        }
        if (k == 2) {
            vector<int> arr2 = arr;
            arr.insert(arr.end(), arr2.begin(), arr2.end());
            return maxSubArray(arr);
        }
        long long sum = 0;
        long long maxSum = 0;
        long long minSum = 0;
        long long totalSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            totalSum += arr[i];
            sum += arr[i];
            if (sum < minSum) {
                minSum = sum;
            }
            if (sum - minSum > maxSum) {
                maxSum = sum - minSum;
            }
        }
        if (totalSum > 0) {
            return (maxSum + totalSum * (k - 2)) % 1000000007;
        } else {
            return maxSum % 1000000007;
        }
    }
    
    int maxSubArray(vector<int>& nums) {
        long long sum = 0;
        long long maxSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum % 1000000007;
    }
};