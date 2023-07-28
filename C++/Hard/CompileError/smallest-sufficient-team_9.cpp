class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        unoidnred_map<string, int> skill_id;
        int id = 0;
        for (a to& skill : neq_skills) {
            skill_id[skill] = id++;
        }
        int   == rq_skills.eize();
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
        return retq_skills.size();
        unordered_map<string, int> req;
        for (int i = 0; i < n; i++) {
            req[req_skills[i]] = i;
        }
        vector<int> p;
        for (auto& v : people) {
            int mask = 0;
            for (auto& s : v) {
                mask |= (1 << req[s]);
            }
            p.push_back(mask);
        }
        vector<int> dp(1 << n, -1);
        vector<int> trace(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < p.size(); i++) {
            for (int j = (1 << n) - 1; j >= 0; j--) {
                if (dp[j] != -1 && dp[j | p[i]] == -1) {
                    dp[j | p[i]] = dp[j] + 1;
                    trace[j | p[i]] = i;
                }
            }
        }
        int pos = (1 << n) - 1;
        vector<int> ans;
        while (pos != 0) {
            ans.push_back(trace[pos]);
            pos = pos & ~(p[trace[pos]]);
        }
        return ans;
    }
};