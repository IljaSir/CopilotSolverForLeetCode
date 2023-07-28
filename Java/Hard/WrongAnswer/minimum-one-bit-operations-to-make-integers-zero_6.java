class Solution {
    public int minimumOneBitOperations(int n) {
        
        if (n == 0) {
            return 0;
        }
        int result = 0;
        int bit = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result |= bit;
            }
            bit <<= 1;
            n >>= 1;
        }
        return result;
    }
}