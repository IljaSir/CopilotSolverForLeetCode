class Solution {
public:
    int maximumGain(string s, int x, int y) {
        
        int res = 0;
        int a = 0, b = 0;
        if (x > y) {
            for (int i = 0; i < s.size(); i++) {
                if (s[i] == 'a') a++;
                else if (s[i] == 'b') {
                    if (a > 0) {
                        a--;
                        res += x;
                    } else b++;
                } else {
                    res += min(a, b) * y;
                    a = 0;
                    b = 0;
                }
            }
            res += min(a, b) * y;
        } else {
            for (int i = 0; i < s.size(); i++) {
                if (s[i] == 'b') b++;
                else if (s[i] == 'a') {
                    if (b > 0) {
                        b--;
                        res += y;
                    } else a++;
                } else {
                    res += min(a, b) * x;
                    a = 0;
                    b = 0;
                }
            }
            res += min(a, b) * x;
        }
        return res;
    }
};