class Solution {
    public int[] evenOddBit(int n) {
        
        int even = 0;
        int odd = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }
}