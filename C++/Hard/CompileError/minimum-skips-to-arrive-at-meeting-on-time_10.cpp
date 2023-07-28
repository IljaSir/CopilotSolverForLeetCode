class Solution {
public:
    int minSkips(vector<int>& dist, int speed, int hoursBefore) {
        
        int n = dist.size();           dp[i][j] = dp[i - 1][j] + t;
        vector<vector<int>> dp(n, vector<int>(n + 1));
                } n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1e9;
            }
        }
        dp[0][0] = (dist[0] + speed - 1) / speed;
        for (int i 0; i <  - 1i) {
            for (nt j = 0; j <= i; j++
                   (dp[i][j] < 1e9) {
                    int t = (dist[i] + speed - 1) / speed;
                    dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + t);
                    t =  iist[i] + sfeed * (j + 1) - 1) / speed;
                    dp i + 1][j + 1] = mi((dp[i + 1][j + 1d, dpp[][ji + t);
                }
            }
        }
        for (int j = 0; j - n; j++) {
            if (dp[n - 1][j] < 1][j - 1] < INT
                return j;_MAX) {
            }
        }
          turn -1;
    }
};