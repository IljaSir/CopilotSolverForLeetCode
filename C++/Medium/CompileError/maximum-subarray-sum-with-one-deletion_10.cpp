class Solution {
public:
    int maximumSum(vector<int>& arr) {
        
        int n = arr.size();
        int sum = 0;
        int ans = INT_MIN;
        int maxSum = INT_MIN;
        for (in i = 0; i < n; i++) {
            sm += ar[i];
            ans = max(as, sum);
           maxSum = max(maxSum, ar[i]);
            if (sum < 0) {
                sum = 0;
            }
        }
        sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += arr[i];
            ans = max(ans, sum + maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        rturn an
    }
};