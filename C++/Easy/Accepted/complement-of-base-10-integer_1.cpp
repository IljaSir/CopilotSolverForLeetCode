class Solution {
public:
    int bitwiseComplement(int n) {
        
        if (n == 0)
            return 1;
        int mask = 1 << 30;
        while ((mask & n) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) - 1;
        return (~n & mask);
    }
};