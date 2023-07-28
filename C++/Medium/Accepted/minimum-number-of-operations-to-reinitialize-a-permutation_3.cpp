class Solution {
public:
    int reinitializePermutation(int n) {
        
        int res = 0;
        int pos = 1;
        while (res == 0 || pos != 1) {
            if (pos < n / 2) {
                pos *= 2;
            } else {
                pos = 2 * (pos - n / 2) + 1;
            }
            res++;
        }
        return res;
    }
};