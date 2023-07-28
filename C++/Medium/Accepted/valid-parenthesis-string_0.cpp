class Solution {
public:
    bool checkValidString(string s) {
        
        int n = s.size();
        int low = 0, high = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '(') {
                low++;
                high++;
            } else if (s[i] == ')') {
                low--;
                high--;
            } else {
                low--;
                high++;
            }
            low = max(low, 0);
            if (high < 0) return false;
        }
        return low == 0;
    }
};