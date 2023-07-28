class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int c0 = 0, c1 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '0') {
                c0++;
            } else {
                c1++;
            }
        }
        if (abs(c0 - c1) > 1) {
            return -1;
        }
        if (c0 > c1) {
            int res = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '0') {
                    res++;
                }
            }
            return res;
        }
        if (c0 < c1) {
            int res = 0;
            for (int i = 0; i < n; i += 2) {
                if (s[i] == '1') {
                    res++;
                }
            }
            return res;
        }
        int res1 = 0;
        for (int i = 0; i < n; i += 2) {
            if (s[i] == '0') {
                res1++;
            }
        }
        int res2 = 0;
        for (int i = 0; i < n; i += 2) {
            if (s[i] == '1') {
                res2++;
            }
        }
        return min(res1, res2);
    }
};