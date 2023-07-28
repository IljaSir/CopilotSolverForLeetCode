class Solution {
public:
    int splitNum(int num) {
        
        int res = 0;
        while (num) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    int split(int num) {
        int res = 0;
        while (num) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    int minSumOfLengths(vector<int>& arr, int target) {
        int n = arr.size();
        int sum = 0;
        int l = 0;
        int minlen = INT_MAX;
        vector<int> dp(n, INT_MAX);
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                if (l > 0 && dp[l-1] != INT_MAX) {
                    minlen = min(minlen, r-l+1+dp[l-1]);
                }
                dp[r] = min(dp[r], r-l+1);
            }
            if (r > 0) {
                dp[r] = min(dp[r], dp[r-1]);
            }
        }
        return minlen == INT_MAX ? -1 : minlen;
    }
    int minSumOfLengths(vector<int>& arr, int target) {
        int n = arr.size();
        int sum = 0;
        int l = 0;
        int minlen = INT_MAX;
        vector<int> dp(n, INT_MAX);
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }
            if (sum == target) {
                if (l > 0 && dp[l-1] != INT_MAX) {
                    minlen = min(minlen, r-l+1+dp[l-1]);
                }
                dp[r] = min(dp[r], r-l+1);
            }
            if (r > 0) {
                dp[r] = min(dp[r], dp[r-1]);
            }
        }
        return minlen == INT_MAX ? -1 : minlen;
    }
};