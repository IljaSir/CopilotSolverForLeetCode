class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        int n = req_skills.size();
        unordered_map<string, int> skill2id;
        for (int i = 0; i < n; ++i) {
            skill2id[req_skills[i]] = i;
        }
        int m = people.size();
        vector<int> dp(1 << n, INT_MAX);
        dp[0] = 0;
        vector<int> pre(1 << n, -1);
        vector<int> path;
        for (int i = 0; i < m; ++i) {
            int state = 0;
            for (auto& skill : people[i]) {
                state |= (1 << skill2id[skill]);
            }
            for (int j = 0; j < (1 << n); ++j) {
                int newstate = j | state;
                if (dp[newstate] > dp[j] + 1) {
                    dp[newstate] = dp[j] + 1;
                    pre[newstate] = j;
                }
            }
        }
        int state = (1 << n) - 1;
        while (state) {
            path.push_back(state);
            state = pre[state];
        }
        reverse(path.begin(), path.end());
        vector<int> ans;
        for (int i = 1; i < path.size(); ++i) {
            int diff = path[i] ^ path[i - 1];
            for (int j = 0; j < m; ++j) {
                int state = 0;
                for (auto& skill : people[j]) {
                    state |= (1 << skill2id[skill]);
                }
                if (state == diff) {
                    ans.push_back(j);
                    break;
                }
            }
        }
        return ans;
    }
};