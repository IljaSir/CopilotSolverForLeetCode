class Solution {
public:
    bool checkString(string s) {
        
        int n = s.length();
        int a = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'a') {
                a++;
            } else {
                if (a == 0) {
                    return false;
                }
            }
        }
        return true;
    }
};