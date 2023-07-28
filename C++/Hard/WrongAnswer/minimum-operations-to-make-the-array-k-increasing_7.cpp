class Solution {
public:
    int kIncreasing(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> dp(n, 0);
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i], dp[i - 1]);
            if (arr[i] > arr[i - 1]) continue;
            int diff = arr[i - 1] - arr[i] + 1;
            arr[i] += diff;
            dp[i] = max(dp[i], dp[max(0, i - k)] + diff);
        }
        return dp[n - 1];
    }
    int minOperations(vector<int>& arr, int k) {
        int n = arr.size();
        vector<int> a;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) continue;
            a.push_back(arr[i]);
        }
        int m = a.size();
        int ans = 1e9;
        for (int i = 0; i < m; i++) {
            vector<int> b;
            for (int j = i; j < m; j++) {
                b.push_back(a[j]);
                if (b.size() >= k) {
                    ans = min(ans, kIncreasing(b, k));
                }
            }
        }
        return ans;
    }
};