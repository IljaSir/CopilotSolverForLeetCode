class Solution {
public:
    int mirrorReflection(int p, int q) {
        
        int m = p, n = q;
        while (m % 2 == 0 && n % 2 == 0) {
            m /= 2;
            n /= 2;
        }
        if (m % 2 == 1 && n % 2 == 0) {
            return 0;
        } else if (m % 2 == 1 && n % 2 == 1) {
            return 1;
        } else {
            return 2;
        }
    }
};