class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        int n = num.size();
        for (int i = 1; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (check(num, 0, i, j)) return true;
            }
        }
        return false;
    }
};