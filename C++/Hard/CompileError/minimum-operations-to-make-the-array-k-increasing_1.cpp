class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        int dp[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + max(0, arr[i] - arr[i-1] + 1);
            if (i >= k) {
                dp[i] = min(dp[i], dp[i-k] + max(0, arr[i] - arr[i-k] + 1));
            }
        }
        return dp[n-1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        int sum = accumulate(arr.begin(), arr.end(), 0);
        int target = sum - k;
        if (target < 0) return -1;
        if (target == 0) return 0;
        int res = n;
        int l = 0, r = 0, cur = 0;
        while (r < n) {
            cur += arr[r];
            while (cur > target) {
                cur -= arr[l];
                l++;
            }
            if (cur == target) {
                res = min(res, n - (r - l + 1));
            }
            r++;
        }
        return res;
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        sort(arr.begin(), arr.end());
        int l = 0, r = 0, cur = 0;
        int res = n;
        while (r < n) {
            cur += arr[r];
            while (cur > k) {
                cur -= arr[l];
                l++;
            }
            if (cur == k) {
                res = min(res, n - (r - l + 1));
            }
            r++;
        }
        return res;
    }
};