class Solution {
    public int[] evenOddBit(int n) {
        
        int even = 0;
        int odd = 0;
        int i = 0;
        while (n > 0) {
            int bit = n & 1;
            if (bit == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n = n >> 1;
            i++;
        }
        return new int[]{even, odd};
    }
}