class Solution {
public:
    bool checkString(string s) {
        
        int a = -1, b = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == 'a') {
                a = i;
            } else {
                b = i;
            }
            if (a != -1 && b != -1 && a > b) {
                return false;
            }
        }
        return true;
    }
};