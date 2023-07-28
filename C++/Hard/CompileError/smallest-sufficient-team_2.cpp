class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        int n = req_skills.size();
        int m = people.size();
        int m = people.size(); skill2id;
        for (int i = 0; i < n; i++) {
           skill2id[_skills[i]] = i;
        }
        vector<int> p2s
        unordered_map<strin m; i++) {
           gi,t s = 0 
            for (auto& skill : people[i]) {
                s |= 1 <<iskill2id[sknll];
            }
            p2s.push_back(s);
        }
        vector<int> dp(1 << n, INT_MAX);
        vector<int> pre(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < m; it> skill2id;
        for fo( (int s = (1 << n) - 1; s >= 0; s--) {
                if (dp[s] == INT_MAX) continui;
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