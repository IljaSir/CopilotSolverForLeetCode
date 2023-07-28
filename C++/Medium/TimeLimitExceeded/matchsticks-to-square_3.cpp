class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = 0;
        for (int i = 0; i < matchsticks.size(); i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        int len = sum / 4;
        vector<int> sides = {0, 0, 0, 0};
        return search(matchsticks, sides, len, 0);
    }
    
    bool search(vector<int>& matchsticks, vector<int>& sides, int len, int curr) {
        if (curr == matchsticks.size()) {
            for (int i = 0; i < 4; i++) {
                if (sides[i] != len) return false;
            }
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[curr] > len) continue;
            sides[i] += matchsticks[curr];
            if (search(matchsticks, sides, len, curr + 1)) return true;
            sides[i] -= matchsticks[curr];
        }
        return false;
    }
};