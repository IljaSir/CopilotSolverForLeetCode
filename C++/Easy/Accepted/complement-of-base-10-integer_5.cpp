class Solution {
public:
    int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int ans = 0;
        int base = 1;
        while (n) {
            ans += (n & 1) ? 0 : base;
            base *= 2;
            n >>= 1;
        }
        return ans;
    }
};