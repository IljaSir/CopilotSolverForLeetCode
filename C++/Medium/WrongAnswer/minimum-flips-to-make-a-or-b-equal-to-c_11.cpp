class Solution {
public:
    int minFlips(int a, int b, int c) {
        
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int tmp = (a >> i) & 1;
            tmp += ((b >> i) & 1);
            tmp += ((c >> i) & 1);
            if (tmp == 0) continue;
            if (tmp == 1) {
                if (((c >> i) & 1) == 0) ++res;
            } else if (tmp == 2) {
                if (((c >> i) & 1) == 1) ++res;
                else res += 2;
            } else {
                res += 2;
            }
        }
        return res;
    }
};