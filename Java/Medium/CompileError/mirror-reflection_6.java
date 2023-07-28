class Solution {
    public int mirrorReflection(int p, int q) {
        
        int g = gcd(p, q);
        p /= g;
        p %= 2;
        q /= g;
        q %= 2;
        return 1 - p + q;
    }
}