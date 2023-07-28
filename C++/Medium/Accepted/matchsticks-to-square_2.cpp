class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = 0;
        for (int i = 0; i < matchsticks.size(); i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        vector<int> sides(4, sum / 4);
        return dfs(matchsticks, sides, 0);
    }
    
    bool dfs(vector<int>& matchsticks, vector<int>& sides, int index) {
        if (index == matchsticks.size()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] >= matchsticks[index]) {
                sides[i] -= matchsticks[index];
                if (dfs(matchsticks, sides, index + 1)) {
                    return true;
                }
                sides[i] += matchsticks[index];
            }
        }
        return false;
    }
};