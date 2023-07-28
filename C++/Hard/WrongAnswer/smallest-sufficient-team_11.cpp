class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        int n = req_skills.size();
        int m = people.size();
        unordered_map<string, int> skill_to_id;
        for(int i = 0; i < n; ++i) {
            skill_to_id[req_skills[i]] = i;
        }
        vector<int> skill(m, 0);
        for(int i = 0; i < m; ++i) {
            for(auto& s : people[i]) {
                skill[i] |= (1 << skill_to_id[s]);
            }
        }
        vector<int> dp(1 << n, INT_MAX);
        vector<int> parent(1 << n, -1);
        dp[0] = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = (1 << n) - 1; j >= 0; --j) {
                if(dp[j] != INT_MAX) {
                    int next = j | skill[i];
                    if(dp[next] > dp[j] + 1) {
                        dp[next] = dp[j] + 1;
                        parent[next] = i;
                    }
                }
            }
        }
        vector<int> res;
        int cur = (1 << n) - 1;
        while(cur) {
            res.push_back(parent[cur]);
            cur &= ~skill[parent[cur]];
        }
        return res;
    }
};