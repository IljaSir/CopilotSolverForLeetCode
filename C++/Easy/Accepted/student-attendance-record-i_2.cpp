class Solution {
public:
    bool checkRecord(string s) {
        
        int a = 0, l = 0;
        for (char c : s) {
            if (c == 'A') {
                a++;
                l = 0;
            } else if (c == 'L') {
                l++;
            } else {
                l = 0;
            }
            if (a > 1 || l > 2) return false;
        }
        return true;
    }
};