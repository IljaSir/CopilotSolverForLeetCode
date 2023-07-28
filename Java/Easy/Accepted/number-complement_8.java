class Solution {
    public int findComplement(int num) {
        
        int bit = 1;
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                res += bit;
            }
            bit <<= 1;
            num >>= 1;
        }
        return res;
    }
}