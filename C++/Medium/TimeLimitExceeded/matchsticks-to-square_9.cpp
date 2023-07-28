class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = 0;
        for (int m : matchsticks) sum += m;
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        vector<int> sums(4, 0);
        return dfs(matchsticks, sums, target, 0);
    }
    bool dfs(vector<int>& matchsticks, vector<int>& sums, int target, int index) {
        if (index == matchsticks.size()) {
            return sums[0] == target && sums[1] == target && sums[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + matchsticks[index] > target) continue;
            sums[i] += matchsticks[index];
            if (dfs(matchsticks, sums, target, index + 1)) return true;
            sums[i] -= matchsticks[index];
        }
        return false;
    }
};