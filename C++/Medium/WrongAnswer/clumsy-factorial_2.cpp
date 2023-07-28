class Solution {
public:
    int clumsy(int n) {
        
        int res = 0;
        switch (n % 4) {
            case 0: res = n; break;
            case 1: res = 1; break;
            case 2: res = n + 1; break;
            case 3: res = 0; break;
        }
        for (int i = n - 1; i >= 4; i -= 4) {
            res -= i * (i - 1) / (i - 2) + (i - 3);
        }
        return res;
    }
};