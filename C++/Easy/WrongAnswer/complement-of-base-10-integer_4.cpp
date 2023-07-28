class Solution {
public:
    int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            if (n & (1 << i)) res |= (1 << i);
            else res &= ~(1 << i);
        }
        return res;
    }
};