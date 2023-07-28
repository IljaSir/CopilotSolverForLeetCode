class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int n = matchsticks.size();
        if (n < 4) return false;
        int sum = 0;
        for (int i = 0; i < n; i++) sum += matchsticks[i];
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        sort(matchsticks.begin(), matchsticks.end(), greater<int>());
        if (matchsticks[0] > target) return false;
        vector<int> sides(4, 0);
        return dfs(matchsticks, 0, sides, target);
    }
};