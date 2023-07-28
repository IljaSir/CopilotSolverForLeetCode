class Solution {
public:
    int minJumps(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 1) return 0;
        unordered_map<int, vector<int>> m;
        for (int i = 0; i < n; ++i) {
            m[arr[i]].push_back(i);
        }
        vector<int> dp(n, n);
        dp[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int i = q.front(); q.pop();
            if (i > 0 && dp[i-1] == n) {
                dp[i-1] = dp[i] + 1;
                q.push(i-1);
            }
            if (i < n - 1 && dp[i+1] == n) {
                dp[i+1] = dp[i] + 1;
                q.push(i+1);
            }
            for (int j : m[arr[i]]) {
                if (dp[j] == n) {
                    dp[j] = dp[i] + 1;
                    q.push(j);
                }
            }
            m[arr[i]].clear();
        }
        return dp[n-1];
    }
};