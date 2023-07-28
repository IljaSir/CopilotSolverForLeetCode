class Solution {
    public int findComplement(int num) {
        
        int result = 0;
        int power = 1;
        while (num > 0) {
            if ((num & 1) == 0) {
                result += power;
            }
            num >>= 1;
            power <<= 1;
        }
        return result;
    }
}