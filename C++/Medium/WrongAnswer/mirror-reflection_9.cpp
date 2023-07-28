class Solution {
public:
    int mirrorReflection(int p, int q) {
        
        int k = p;
        while (k % 2 == 0 && k % q != 0) k += p;
        return (k / q) % 2 == 0 ? 0 : 1 + k / p % 2;
    }
};