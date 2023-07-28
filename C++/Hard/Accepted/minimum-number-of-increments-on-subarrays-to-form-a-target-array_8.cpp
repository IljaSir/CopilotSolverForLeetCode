class Solution {
public:
    int minNumberOperations(vector<int>& target) {
        
        int res = 0, n = target.size();
        for (int i = 0; i < n; ++i) {
            if (i == 0 || target[i] > target[i - 1]) {
                res += target[i] - (i == 0 ? 0 : target[i - 1]);
            }
        }
        return res;
    }
};