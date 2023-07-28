class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = 0;
        for (int i = 0; i < matchsticks.size(); ++i) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) {
            return false;
        }
        int len = sum / 4;
        vector<bool> used(matchsticks.size(), false);
        return dfs(matchsticks, used, 0, len, 0, 4);
    }
    bool dfs(vector<int>& matchsticks, vector<bool>& used, int start, int len, int cur, int k) {
        if (k == 1) {
            return true;
        }
        if (cur == len) {
            return dfs(matchsticks, used, 0, len, 0, k - 1);
        }
        for (int i = start; i < matchsticks.size(); ++i) {
            if (!used[i] && cur + matchsticks[i] <= len) {
                used[i] = true;
                if (dfs(matchsticks, used, i + 1, len, cur + matchsticks[i], k)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
};