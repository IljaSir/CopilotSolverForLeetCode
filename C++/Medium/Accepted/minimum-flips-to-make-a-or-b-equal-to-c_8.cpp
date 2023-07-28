class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        int r = 0;
        while (a || b || c) {
            if (c & 1) {
                if (!(a & 1) && !(b & 1)) {
                    r++;
                }
            } else {
                if (a & 1) {
                    r++;
                }
                if (b & 1) {
                    r++;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return r;
    }
};