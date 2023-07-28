class Solution {
public:
    int findComplement(int num) {
        
        int comp = 0;
        int base = 1;
        while (num) {
            if (num & 1) {
                num >>= 1;
            } else {
                comp += base;
                num >>= 1;
            }
            base <<= 1;
        }
        return comp;
    }
};