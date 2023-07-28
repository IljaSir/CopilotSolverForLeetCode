class Solution {
public:
    bool checkValidString(string s) {
        
        int n = s.size();
        int minBalance = 0, maxBalance = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                minBalance++;
                maxBalance++;
            } else if (s[i] == ')') {
                if (minBalance > 0) {
                    minBalance--;
                }
                maxBalance--;
            } else {
                if (minBalance > 0) {
                    minBalance--;
                }
                maxBalance++;
            }
            if (maxBalance < 0) {
                return false;
            }
        }
        return minBalance == 0;
    }
};