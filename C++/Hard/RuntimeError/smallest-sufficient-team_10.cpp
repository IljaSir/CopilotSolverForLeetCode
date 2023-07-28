class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        
        unordered_map<string, int> skillIndex;
        for (int i = 0; i < req_skills.size(); ++i) {
            skillIndex[req_skills[i]] = i;
        }
        
        vector<int> peopleSkills(people.size());
        for (int i = 0; i < people.size(); ++i) {
            for (auto& skill : people[i]) {
                peopleSkills[i] |= (1 << skillIndex[skill]);
            }
        }
        
        vector<int> dp(1 << req_skills.size(), INT_MAX);
        dp[0] = 0;
        vector<int> parent(1 << req_skills.size(), -1);
        
        for (int i = 0; i < people.size(); ++i) {
            for (int state = (1 << req_skills.size()) - 1; state >= 0; --state) {
                int nextState = state | peopleSkills[i];
                if (dp[nextState] > dp[state] + 1) {
                    dp[nextState] = dp[state] + 1;
                    parent[nextState] = i;
                }
            }
        }
        
        vector<int> res;
        int state = (1 << req_skills.size()) - 1;
        while (state) {
            res.push_back(parent[state]);
            state &= ~(peopleSkills[parent[state]]);
        }
        return res;
    }
};