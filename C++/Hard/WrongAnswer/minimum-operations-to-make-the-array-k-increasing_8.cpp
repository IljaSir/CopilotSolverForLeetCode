class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for(int i = 1; i < n; i++) {
            dp[i] = dp[i-1];
            if(arr[i] > arr[i-1]) continue;
            int diff = arr[i-1] - arr[i] + 1;
            dp[i] += diff;
            arr[i] += diff;
            if(i >= k) arr[i-k] -= diff;
        }
        return dp[n-1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> sum(n+1, 0);
        for(int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + arr[i];
        }
        int res = INT_MAX;
        for(int i = k; i <= n; i++) {
            int l = i-k, r = i-1;
            int mid = (l+r)/2;
            int sum1 = sum[mid+1] - sum[l];
            int sum2 = sum[r+1] - sum[mid+1];
            int diff = sum2 - sum1;
            res = min(res, kIncreasing(arr, mid-l+1) + kIncreasing(arr, r-mid) + diff);
        }
        return res;
    }
};