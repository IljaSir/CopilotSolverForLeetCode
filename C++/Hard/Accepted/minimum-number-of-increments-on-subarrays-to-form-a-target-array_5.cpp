class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        
        int res = 0;
        for (int i = 0; i < target.size(); i++) {
            if (i == 0) {
                res += target[i];
            } else {
                res += max(0, target[i] - target[i - 1]);
            }
        }
        return res;
    }
};