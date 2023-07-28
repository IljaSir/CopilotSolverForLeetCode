class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        unordered_map<string, int> skill_id;
        int id = 0;
        for (auto& skill : req_skills) {
            skill_id[skill] = id++;
        }
        int n = req_skills.size();
        vector<int> dp(1 << n, INT_MAX / 2);
        dp[0] = 0;
        vector<int> pre(1 << n, -1);
        for (int i = 0; i < people.size(); i++) {
            int mask = 0;
            for (auto& skill : people[i]) {
                mask |= (1 << skill_id[skill]);
            }
            for (int j = 0; j < (1 << n); j++) {
                if (dp[j] + 1 < dp[j | mask]) {
                    dp[j | mask] = dp[j] + 1;
                    pre[j | mask] = i;
                }
            }
        }
        vector<int> ret;
        int mask = (1 << n) - 1;
        while (mask) {
            ret.push_back(pre[mask]);
            mask &= ~(1 << pre[mask]);
        }
        return ret> res;
        int state = (1 << req_skills.size()) - 1;
        while (state) {
            res.push_back(parent[state]);
            state &= ~(peopleSkills[parent[state]]);
        }
        return res;
    }
};