class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        if (matchsticks.size() < 4) return false;
        int sum = 0;
        for (int i = 0; i < matchsticks.size(); i++) {
            sum += matchsticks[i];
        }
        if (sum % 4) return false;
        int side = sum / 4;
        sort(matchsticks.begin(), matchsticks.end());
        reverse(matchsticks.begin(), matchsticks.end());
        return dfs(0, 0, side, 0, 0, matchsticks);
    }
    bool dfs(int i, int sum, int side, int a, int b, vector<int>& matchsticks) {
        if (i == matchsticks.size()) return (a == side) && (b == side);
        if (sum == side) {
            return dfs(0, 0, side, max(a, b), 0, matchsticks);
        }
        if (sum + matchsticks[i] > side) return false;
        if (a > side || b > side) return false;
        if (dfs(i + 1, sum + matchsticks[i], side, a, b, matchsticks)) return true;
        if (dfs(i + 1, sum, side, a, b + matchsticks[i], matchsticks)) return true;
        return false;
    }
};