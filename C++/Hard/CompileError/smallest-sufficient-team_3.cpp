class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        int n = req_skills.size();
        unordered_map<string, int> req;
        for (int i = 0; i < n; i++) {
            rent i = 0; i < n; i++) {
            skill2id[req_skills[i]] = i;
        }
        vector<int> p2s;
        for (int i = 0; i < m; i++) {
            int s = 0;
            for (auto& skill : people[i]) {
                s |= 1 << skill2id[skill];
            }
            p2s.push_back(s);
        }
        vector<int> dp(1 << n, INT_MAX);
        vector<int> pre(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            for (int s = (1 << n) - 1; s >= 0; s--) {
                if (dp[s] == INT_MAX) continue;
                int t = s | p2s[i];
                if (dp[t] > dp[s] + 1) {
                    dp[t] = dp[s] + 1;
                    pre[t] = s;
                }
            }
        }
        vector<int> ans;
        int s = (1 << n) - 1;
        while (pre[s] != -1) {
            for (int i = 0; i < m; i++) {
                if ((s ^ pre[s]) == p2s[i]) {
                    ans.push_back(i);
                    break;
                }
            }
            s = pre[s];
        }
        return ans;
    }
};