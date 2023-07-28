class Solution {
    public int findComplement(int num) {
        
        int result = 0;
        int power = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                result += (1 << power);
            }
            num = num >> 1;
            power += 1;
        }
        return result;
    }
}