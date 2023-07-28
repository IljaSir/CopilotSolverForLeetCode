class Solution {
public:
    int bestTeamScore(vector<int>& scores, vector<int>& ages) {
        
        vector<pair<int, int>> p;
        for(int i = 0; i < scores.size(); i++){
            p.push_back(make_pair(ages[i], scores[i]));
        }
        sort(p.begin(), p.end());
        vector<int> dp(scores.size(), 0);
        dp[0] = p[0].second;
        int res = dp[0];
        for(int i = 1; i < scores.size(); i++){
            dp[i] = p[i].second;
            for(int j = 0; j < i; j++){
                if(p[i].second >= p[j].second){
                    dp[i] = max(dp[i], dp[j] + p[i].second);
                }
            }
            res = max(res, dp[i]);
        }
        return res;
    }
};