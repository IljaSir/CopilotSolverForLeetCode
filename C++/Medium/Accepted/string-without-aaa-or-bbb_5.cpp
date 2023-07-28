class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string res;
        while (a > 0 || b > 0) {
            bool writeA = false;
            int L = res.length();
            if (L >= 2 && res[L-1] == res[L-2]) {
                if (res[L-1] == 'b') {
                    writeA = true;
                }
            } else {
                if (a >= b) {
                    writeA = true;
                }
            }
            if (writeA) {
                --a;
                res += 'a';
            } else {
                --b;
                res += 'b';
            }
        }
        return res;
    }
};