class Solution {
public:
    int findLatestStep(vector<int>& arr, int m) {
        
        int n = arr.size();
        vector<int> dp(n + 2, 0);
        vector<int> len(n + 2, 0);
        int res = -1;
        for (int i = 0; i < n; ++i) {
            int a = arr[i];
            dp[a] = 1;
            len[a] = 1;
            if (dp[a - 1] == 1) {
                len[a] += len[a - 1];
                len[a - len[a - 1]] = len[a];
            }
            if (dp[a + 1] == 1) {
                len[a] += len[a + 1];
                len[a + len[a + 1]] = len[a];
            }
            if (len[a] == m) {
                res = i + 1;
            }
        }
        return res;
    }
};