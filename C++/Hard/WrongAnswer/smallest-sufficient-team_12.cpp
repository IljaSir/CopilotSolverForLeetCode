class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        unordered_map<string, int> skill2id;
        int skill_id = 0;
        for (auto& skill : req_skills) {
            skill2id[skill] = skill_id++;
        }
        int n = people.size();
        int m = 1 << req_skills.size();
        vector<int> dp(m, INT_MAX);
        dp[0] = 0;
        vector<int> pre(m);
        for (int i = 0; i < n; i++) {
            int state = 0;
            for (auto& skill : people[i]) {
                state |= (1 << skill2id[skill]);
            }
            for (int j = 0; j < m; j++) {
                if (dp[j] != INT_MAX) {
                    int new_state = state | j;
                    if (dp[new_state] > dp[j] + 1) {
                        dp[new_state] = dp[j] + 1;
                        pre[new_state] = j;
                    }
                }
            }
        }
        vector<int> res;
        int state = m - 1;
        while (state) {
            if (pre[state] != state) {
                res.push_back(state - pre[state]);
            }
            state = pre[state];
        }
        return res;
    }
};