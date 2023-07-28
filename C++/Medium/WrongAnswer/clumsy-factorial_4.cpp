class Solution {
public:
    int clumsy(int n) {
        
        int res = 0;
        int i = 0;
        while (n > 0) {
            if (i == 0) {
                res += n;
            } else if (i == 1) {
                res *= n;
            } else if (i == 2) {
                res /= n;
            } else {
                res += n;
            }
            n--;
            i++;
            if (i == 4) {
                i = 0;
            }
        }
        return res;
    }
};