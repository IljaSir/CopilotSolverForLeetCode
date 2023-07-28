class Solution {
public:
    int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int bit = 0;
        int res = 0;
        while (n) {
            if ((n & 1) == 0) {
                res += pow(2, bit);
            }
            n >>= 1;
            ++bit;
        }
        return res;
    }
};