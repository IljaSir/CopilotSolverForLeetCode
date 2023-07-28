class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> index(n);
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        sort(index.begin(), index.end(), [&](int i, int j) {
            return arr[i] < arr[j];
        });
        for (int i = 0; i < n; i++) {
            int idx = index[i];
            for (int j = idx - 1; j >= max(0, idx - d); j--) {
                if (arr[j] >= arr[idx]) {
                    break;
                }
                dp[idx] = max(dp[idx], dp[j] + 1);
            }
            for (int j = idx + 1; j <= min(n - 1, idx + d); j++) {
                if (arr[j] >= arr[idx]) {
                    break;
                }
                dp[idx] = max(dp[idx], dp[j] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};