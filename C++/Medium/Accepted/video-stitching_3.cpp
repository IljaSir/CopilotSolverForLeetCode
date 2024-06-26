class Solution {
public:
    int videoStitching(vector<vector<int>>& clips, int time) {
        
        vector<int> dp(time+1, 10001);
        dp[0] = 0;
        for (int i=1; i<=time; i++) {
            for (auto& clip: clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == 10001? -1: dp[time];
    }
};