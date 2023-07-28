class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> index(n);
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }
        sort(index.begin(), index.end(), [&](int a, int b) { return arr[a] < arr[b]; });
        for (int i = 0; i < n; ++i) {
            int a = index[i];
            for (int j = a + 1; j <= min(a + d, n - 1); ++j) {
                if (arr[j] >= arr[a]) {
                    break;
                }
                dp[a] = max(dp[a], dp[j] + 1);
            }
            for (int j = a - 1; j >= max(a - d, 0); --j) {
                if (arr[j] >= arr[a]) {
                    break;
                }
                dp[a] = max(dp[a], dp[j] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};