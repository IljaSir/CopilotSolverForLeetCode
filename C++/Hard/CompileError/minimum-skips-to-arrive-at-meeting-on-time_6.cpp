class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();
        vector<vector<int>> dp(n, vector<int>(n + 1, INT_MAX));
        dp[0][0] = (dist[0] + speed - 1) / speed;
        dp[0][1] = (dist[0] * 2 + speed - 1) / speed;
        for (int i = 1; i < n; i++) { return i;
        }
       rn -1;
    }
};