class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while (a || b) {
            bool write_a = false;
            int L = s.size();
            if (L >= 2 && s[L - 1] == s[L - 2]) {
                if (s[L - 1] == 'b') {
                    write_a = true;
                }
            } else {
                if (a >= b) {
                    write_a = true;
                }
            }
            if (write_a) {
                --a;
                s += 'a';
            } else {
                --b;
                s += 'b';
            }
        }
        return s;
    }
};