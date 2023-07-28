class Solution {
public:
    bool checkRecord(string s) {
        
        int a = 0;
        int l = 0;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] == 'A') {
                a++;
                l = 0;
            } else if (s[i] == 'L') {
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