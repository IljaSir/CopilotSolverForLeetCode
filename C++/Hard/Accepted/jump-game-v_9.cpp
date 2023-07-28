class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        int dp[n];
        for (int i = 0; i < n; i++) dp[i] = 1;
        vector<int> index;
        for (int i = 0; i < n; i++) {
            index.push_back(i);
        }
        sort(index.begin(), index.end(), [&arr](int i, int j) { return arr[i] < arr[j]; });
        for (int i = 0; i < n; i++) {
            int j = index[i];
            for (int k = j + 1; k <= min(j + d, n - 1); k++) {
                if (arr[k] >= arr[j]) break;
                dp[j] = max(dp[j], dp[k] + 1);
            }
            for (int k = j - 1; k >= max(j - d, 0); k--) {
                if (arr[k] >= arr[j]) break;
                dp[j] = max(dp[j], dp[k] + 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) ans = max(ans, dp[i]);
        return ans;
    }
};