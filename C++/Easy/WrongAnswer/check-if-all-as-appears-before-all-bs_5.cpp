class Solution {
public:
    bool checkString(string s) {
        
        int n = s.length();
        int a = 0, b = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == 'a') {
                a++;
            }
            else {
                b++;
            }
            if(b > a) {
                return false;
            }
        }
        return true;
    }
};