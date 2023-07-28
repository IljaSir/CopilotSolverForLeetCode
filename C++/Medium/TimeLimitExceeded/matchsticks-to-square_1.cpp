class Solution {
public:
    bool makesquare(vector<int>& matchsticks) {
        
        int sum = 0;
        for (int i = 0; i < matchsticks.size(); i++) {
            sum += matchsticks[i];
        }
        if (sum % 4 != 0) return false;
        int target = sum / 4;
        if (*max_element(matchsticks.begin(), matchsticks.end()) > target) return false;
        vector<int> sides(4, 0);
        return search(matchsticks, sides, target, 0);
    }
    bool search(vector<int>& matchsticks, vector<int>& sides, int target, int index) {
        if (index == matchsticks.size()) {
            return sides[0] == target && sides[1] == target && sides[2] == target;
        }
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] > target) continue;
            sides[i] += matchsticks[index];
            if (search(matchsticks, sides, target, index + 1)) return true;
            sides[i] -= matchsticks[index];
        }
        return false;
    }
};