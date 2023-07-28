class Solution {
public:
    bool hasAlternatingBits(int n) {
        
        while (n > 0) {
            int lastBit = n & 1;
            n >>= 1;
            if (n > 0 && (n & 1) == lastBit)
                return false;
        }
        return true;
    }
};