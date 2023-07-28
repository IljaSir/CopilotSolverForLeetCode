class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        int n = req_skills.size();
        int m = people.size();
        unordered_map<string, int> skill_id;
        for (int i = 0; i < n; ++i) {
            skill_id[req_skills[i]] = i;
        }
        vector<int> skill_mask(m);
        for (int i = 0; i < m; ++i) {
            for (const auto& s : people[i]) {
                skill_mask[i] |= (1 << skill_id[s]);
            }
        }
        vector<int> dp(1 << n, INT_MAX);
        vector<int> last(1 << n, -1);
        dp[0] = 0;
        for (int i = 0; i < m; ++i) {
            for (int mask = (1 << n) - 1; mask >= 0; --mask) {
                int next = mask | skill_mask[i];
                if (dp[next] > dp[mask] + 1) {
                    dp[next] = dp[mask] + 1;
                    last[next] = i;
                }
            }
        }
        vector<int> ret;
        for (int mask = (1 << n) - 1; mask > 0; mask = mask & (mask - 1)) {
            ret.push_back(last[mask]);
        }
        return ret;
    }
};