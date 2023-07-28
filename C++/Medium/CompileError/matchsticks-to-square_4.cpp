class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        if (matchsticks.size() < 4) return false;
        int sum = accumulate(matchsticks.begin(), matchsticks.end(), 0);
        if (sum % 4 != 0) return false;
        int side = sum / 4;
        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        if (matchsticks[0] > side) return false;
        vector<int> sides(4, 0);
        return dfs(matchsticks, sides, 0, side);
    }
};