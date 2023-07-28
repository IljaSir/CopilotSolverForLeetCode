class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        int res = 0;
        int i = 0;
        while (a || b || c) {
            int a_bit = a & 1;
            int b_bit = b & 1;
            int c_bit = c & 1;
            if (c_bit == 0) {
                res += a_bit + b_bit;
            } else {
                if (a_bit == 0 && b_bit == 0) {
                    res += 1;
                }
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return res;
    }
};