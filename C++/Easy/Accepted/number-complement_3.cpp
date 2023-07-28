class Solution {
public:
    int findComplement(int num) {
        
        int result = 0;
        int bit = 0;
        while (num) {
            if ((num & 1) == 0) {
                result += (1 << bit);
            }
            bit++;
            num >>= 1;
        }
        return result;
    }
};