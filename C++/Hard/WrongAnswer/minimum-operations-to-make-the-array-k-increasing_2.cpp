class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; ++i) {
            int diff = arr[i] - arr[i - 1];
            if (diff > 0) {
                continue;
            }
            int change = 1 - diff;
            arr[i] += change;
            dp[i] += change;
            if (i >= k) {
                dp[i] += dp[i - k];
            }
        }
        return accumulate(dp.begin(), dp.end(), 0);
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> sums;
        for (int i = 0; i < n; ++i) {
            int sum = arr[i];
            for (int j = i + 1; j < n; ++j) {
                sum += arr[j];
                sums.push_back(sum);
            }
        }
        sort(sums.begin(), sums.end());
        int ans = 1e9;
        for (int i = 0; i < sums.size(); ++i) {
            int sum = sums[i];
            int cnt = i + 1;
            if (sum > k) {
                continue;
            }
            int change = k - sum;
            if (change % cnt == 0) {
                int op = change / cnt;
                ans = min(ans, kIncreasing(arr, op));
            }
        }
        return ans;
    }
};