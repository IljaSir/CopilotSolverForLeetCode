class Solution {
public:
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        
        int n = arr.size();
        long long int sum = 0, maxSum = 0, curr = 0, totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += arr[i];
            curr += arr[i];
            if(curr < 0) curr = 0;
            maxSum = max(maxSum, curr);
        }
        curr = 0;
        for(int i = n-1; i >= 0; i--) {
            curr += arr[i];
            if(curr < 0) curr = 0;
            maxSum = max(maxSum, curr);
        }
        if(k == 1) return maxSum % 1000000007;
        if(totalSum > 0) {
            sum = totalSum * (k-2);
            curr = 0;
            for(int i = 0; i < n; i++) {
                curr += arr[i];
                if(curr < 0) curr = 0;
                maxSum = max(maxSum, curr + sum);
            }
            curr = 0;
            for(int i = n-1; i >= 0; i--) {
                curr += arr[i];
                if(curr < 0) curr = 0;
                maxSum = max(maxSum, curr + sum);
            }
        }
        return maxSum % 1000000007;
    }
};