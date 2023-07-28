class Solution {
public:
    int rotatedDigits(int n) {
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isValid(i)) {
                res++;
            }
        }
        return res;
    }
};