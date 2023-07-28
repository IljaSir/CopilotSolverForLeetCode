class Solution {
public:
    bool hasAlternatingBits(int n) {
        
        int last = -1;
        while (n > 0) {
            int bit = n & 1;
            if (bit == last) {
                return false;
            }
            last = bit;
            n >>= 1;
        }
        return true;
    }
};