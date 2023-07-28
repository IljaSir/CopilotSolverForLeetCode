class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while (a > 0 || b > 0) {
            bool writeA = false;
            int l = s.length();
            if (l >= 2 && s[l - 1] == s[l - 2]) {
                if (s[l - 1] == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b) {
                    writeA = true;
                }
            }
            if (writeA) {
                --a;
                s.push_back('a');
            } else {
                --b;
                s.push_back('b');
            }
        }
        return s;
    }
};