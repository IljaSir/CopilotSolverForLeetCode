class Solution {
    public int getSum(int a, int b) {
        
        int sum = 0;
        int carry = 0;
        for(int i = 0; i < 32; i++) {
            int aBit = a & 1;
            int bBit = b & 1;
            if(aBit == 1 && bBit == 1) {
                if(carry == 1) {
                    sum = sum | (1 << i);
                }
                carry = 1;
            } else if(aBit == 1 || bBit == 1) {
                if(carry == 1) {
                    carry = 1;
                } else {
                    sum = sum | (1 << i);
                    carry = 0;
                }
            } else {
                if(carry == 1) {
                    sum = sum | (1 << i);
                }
                carry = 0;
            }
            a = a >> 1;
            b = b >> 1;
        }
        return sum;
    }
}