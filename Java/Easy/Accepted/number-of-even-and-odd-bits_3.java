class Solution {
    public int[] evenOddBit(int n) {
        
        int even = 0;
        int odd = 0;
        int i = 0;
        while (n > 0) {
            if (i % 2 == 0 && (n & 1) == 1) {
                even++;
            }
            if (i % 2 == 1 && (n & 1) == 1) {
                odd++;
            }
            n >>= 1;
            i++;
        }
        return new int[] {even, odd};
    }
}