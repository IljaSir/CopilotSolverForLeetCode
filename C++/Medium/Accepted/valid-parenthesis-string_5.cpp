class Solution {
public:
    bool checkValidString(string s) {
        
        int max = 0, min = 0;
        for (char c : s) {
            if (c == '(') {
                max++;
                min++;
            }
            else if (c == ')') {
                max--;
                min--;
            }
            else if (c == '*') {
                max++;
                min--;
            }
            if (max < 0) {
                return false;
            }
            min = min < 0 ? 0 : min;
        }
        return min == 0;
    }
};