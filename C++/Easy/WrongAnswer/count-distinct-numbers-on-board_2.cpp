class Solution {
public:
    int distinctIntegers(int n) {
        
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 2;
        for (int i = 3; i <= n; i++) {
            res += (n / i) + (n % i ? 1 : 0);
        }
        return res;
    }
};