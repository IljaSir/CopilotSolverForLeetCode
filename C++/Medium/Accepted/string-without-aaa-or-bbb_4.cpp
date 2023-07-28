class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while (a || b) {
            bool writeA = false;
            int L = s.size();
            if (L >= 2 && s[L - 1] == s[L - 2]) {
                if (s[L - 1] == 'b') writeA = true;
            } else {
                if (a >= b) writeA = true;
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