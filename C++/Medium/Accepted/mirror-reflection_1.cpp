class Solution {
public:
    int mirrorReflection(int p, int q) {
        
        int g = gcd(p, q);
        p /= g;
        p %= 2;
        q /= g;
        q %= 2;
        if (p == 1 && q == 1) return 1;
        if (p == 1 && q == 0) return 0;
        if (p == 0 && q == 1) return 2;
        return -1;
    }
};