class Solution {
public:
    int maxJumps(vector<int>& arr, int d) {
        
        int N = arr.size();
        vector<int> dp(N, 1);
        vector<pair<int, int>> v;
        for (int i = 0; i < N; i++) {
            v.push_back({arr[i], i});
        }
        sort(v.begin(), v.end());
        for (auto p : v) {
            int i = p.second;
            for (int j = i - 1; j >= max(0, i - d); j--) {
                if (arr[j] >= arr[i]) break;
                dp[i] = max(dp[i], dp[j] + 1);
            }
            for (int j = i + 1; j <= min(N - 1, i + d); j++) {
                if (arr[j] >= arr[i]) break;
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
        return *max_element(dp.begin(), dp.end());
    }
};