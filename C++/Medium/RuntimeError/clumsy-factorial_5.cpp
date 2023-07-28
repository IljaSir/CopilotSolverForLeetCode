class Solution {
public:
    int clumsy(int n) {
        
        int res = 0;
        int flag = 0;
        while (n) {
            if (flag == 0) {
                res += n;
            } else if (flag == 1) {
                res *= n;
            } else if (flag == 2) {
                res /= n;
            } else {
                res += n;
                n -= 1;
                if (n) {
                    res -= n;
                }
            }
            n -= 1;
            flag = (flag + 1) % 4;
        }
        return res;
    }
};