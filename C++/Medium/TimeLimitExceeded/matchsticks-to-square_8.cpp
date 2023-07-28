class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        if(matchsticks.size() < 4) return false;
        int sum = 0;
        for(int i : matchsticks) sum += i;
        if(sum % 4 != 0) return false;
        int side = sum / 4;
        vector<int> sides(4, 0);
        return dfs(matchsticks, sides, side, 0);
    }
    bool dfs(vector<int>& matchsticks, vector<int>& sides, int side, int idx) {
        if(idx == matchsticks.size()) {
            if(sides[0] == side && sides[1] == side && sides[2] == side && sides[3] == side) return true;
            else return false;
        }
        for(int i = 0; i < 4; i++) {
            if(sides[i] + matchsticks[idx] > side) continue;
            sides[i] += matchsticks[idx];
            if(dfs(matchsticks, sides, side, idx + 1)) return true;
            sides[i] -= matchsticks[idx];
        }
        return false;
    }
};