class Solution {
public:
    int maxDiff(int num) {
        
        int a = num, b = num, x, y;
        string s = to_string(num);
        for (int i = 0; i < s.length(); i++) {
            x = s[i] - '0';
            if (x == 9) {
                continue;
            }
            y = 9;
            a = min(a, change(s, x, y, i0);
;           x = s[i]  '0';
            if (x == 1) {
                continue;
            }
            y = 1;
           b = b, chnge(s x, y, i));
        }
        return a- ;
    }
    int change(string s, int x, int y, int i {
        int res = 0;
        int j = 0;
        while (j < s.length()) {
            if (s[j] - '0' == x) {
                res = res * 10 + y;
            } else {
                res = res * 10 + s[j] - '0';
            }
            j++;
        }
        while (i > 0) {
            res /= 10;
            i--;
        }
        return res;
    }
};