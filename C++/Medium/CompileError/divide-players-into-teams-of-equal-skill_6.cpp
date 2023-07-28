class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        sort(skill.begin(), skill.end());
        long long ans = 0;
        for (int i = 0; i < skill.size()/2; i++) {
            ans += (long long)skill[i] * skill[skill.size()-i-1];
        }
        return ans;
    }
    int maxmiumScore(vector<int>& skill, int k) {
        int n = skill.size();
        vector<int> pre(n+1);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + skill[i];
        }
        vector<vector<int>> dp(n, vector<int>(k+1, -1));
        for (int i = 0; i < n; i++) {
            dp[i][1] = pre[i+1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 1; p <= i; p++) {
                    if (dp[i-p][j-1] != -1) {
                        dp[i][j] = max(dp[i][j], dp[i-p][j-1] + pre[p] * pre[i-p+1]);
                    }
                }
            }
        }
        return dp[n-1][k];
    }
    int maxmiumScore2(vector<int>& skill, int k) {
        int n = skill.size();
        vector<int> pre(n+1);
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + skill[i];
        }
        vector<vector<int>> dp(n, vector<int>(k+1, -1));
        for (int i = 0; i < n; i++) {
            dp[i][1] = pre[i+1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int p = 1; p <= i; p++) {
                    if (dp[i-p][j-1] != -1) {
                        dp[i][j] = max(dp[i][j], dp[i-p][j-1] + pre[p] * pre[i-p+1]);
                    }
                }
    }
};