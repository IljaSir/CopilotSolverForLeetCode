class Solution {
public:
    bool checkString(string s) {
        
        int n = s.length();
        int a = 0;
        int b = 0;
        for(int i = 0; i < n; i++) {
            if(s[i] == 'a') {
                a++;
            }
            if(s[i] == 'b') {
                b++;
            }
            if(b > 0 && a == 0) {
                return false;
            }
        }
        return true;
    }
};