class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> sorted;
        for (int i = 0; i < n; ++i) {
            sorted.push_back(i);
        }
        sort(sorted.begin(), sorted.end(), [&arr](int i, int j) { return arr[i] < arr[j]; });
        for (auto &i: sorted) {
            for (int j = i + 1; j <= min(i + d, n - 1); ++j) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = max(dp[i], dp[j] + 1);
            }
            for (int j = i - 1; j >= max(i - d, 0); --j) {
                if (arr[j] >= arr[i]) {
                    break;
                }
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        int ans = 0;
        for (auto &i: dp) {
            ans = max(ans, i);
        }
        return ans;
    }
};