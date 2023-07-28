class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int n = arr.size();
        vector<int> dp(n, 1);
        vector<int> order(n);
        for (int i = 0; i < n; ++i) {
            order[i] = i;
        }
        sort(order.begin(), order.end(), [&arr](int a, int b) {
            return arr[a] < arr[b];
        });
        for (int i = 0; i < n; ++i) {
            int index = order[i];
            for (int j = index - 1; j >= max(0, index - d); --j) {
                if (arr[j] >= arr[index]) {
                    break;
                }
                dp[index] = max(dp[index], dp[j] + 1);
            }
            for (int j = index + 1; j <= min(n - 1, index + d); ++j) {
                if (arr[j] >= arr[index]) {
                    break;
                }
                dp[index] = max(dp[index], dp[j] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};