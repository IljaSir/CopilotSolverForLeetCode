class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = accumulate(matchsticks.begin(), matchsticks.end(), 0);
        if (sum % 4) return false;
        int side = sum / 4;
        vector<int> sides(4, 0);
        sort(matchsticks.rbegin(), matchsticks.rend());
        return dfs(matchsticks, sides, side, 0);
    }
    
    bool dfs(vector<int>& matchsticks, vector<int>& sides, int side, int index) {
        if (index == matchsticks.size()) {
            if (sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3]) {
                return true;
            }
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > side) continue;
            sides[i] += matchsticks[index];
            if (dfs(matchsticks, sides, side, index + 1)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }
};