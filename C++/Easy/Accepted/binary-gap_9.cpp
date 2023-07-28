class Solution {
public:
    int binaryGap(int n) {
        
        int ret = 0;
        int p = 0;
        int q = 0;
        bool flag = false;
        while (n > 0) {
            if (n & 1) {
                if (flag) {
                    ret = max(ret, q - p);
                } else {
                    flag = true;
                }
                p = q;
            }
            n >>= 1;
            q++;
        }
        return ret;
    }
};