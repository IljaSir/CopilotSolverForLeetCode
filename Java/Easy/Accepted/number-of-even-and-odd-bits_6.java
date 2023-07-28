class Solution {
    public int[] evenOddBit(int n) {
        
        int even = 0;
        int odd = 0;
        int i = 0;
        while (n > 0) {
            if (n % 2 != 0) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n = n / 2;
            i++;
        }
        return new int[] {even, odd};
    }
}