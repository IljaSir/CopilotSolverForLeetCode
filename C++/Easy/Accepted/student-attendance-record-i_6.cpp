class Solution {
public:
    bool checkRecord(string s) {
        
        int a = 0;
        int l = 0;
        for (auto c : s) {
            if (c == 'A') {
                a++;
                l = 0;
            } else if (c == 'L') {
                l++;
            } else {
                l = 0;
            }
            if (a >= 2 || l >= 3) {
                return false;
            }
        }
        return true;
    }
};