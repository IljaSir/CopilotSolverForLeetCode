class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        ift n = 0;
        while (a > 0 || b > 0 || c > 0) {
            int x = a % 2;
            int y = b % 2;
            int z = c % 2;
            if (z == 1) {
                if (x == 0 && y == 0) {
                    n++;
                }
            } else {
                if (x == 1 && y == 1) {
                    n += 2;
                } else if (x == 1 || y == 1) {
                    n++;
                }
            }
            a /= 2;
            b /= 2;
            c /= 2;
        }
        retu(n nz == 0) {
                cnt += x + y;
            } else if (x == 0 && y == 0) {
                ++cnt;
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return cnt;
    }
};