class Solution {
    public int bitwiseComplement(int n) {
        
        if (n == 0) return 1;
        int mask = 1;
        int temp = n;
        while (temp > 0) {
            temp = temp >> 1;
            mask = mask << 1;
        }
        return n ^ (mask - 1);
    }
}