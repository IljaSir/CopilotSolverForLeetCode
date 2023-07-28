class Solution {
public:
    int minSwaps(string s) {
        
        int n = s.size();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == (i % 2 == 0 ? '0' : '1')) {
                c1++;
            } else {
                c2++;
            }
        }
        if (abs(c1 - c2) > 1) {
            return -1;
        }
        if (c1 > c2) {
            return c2;
        }
        return c1;
    }
};