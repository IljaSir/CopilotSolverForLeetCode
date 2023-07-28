class Solution {
    public int hammingDistance(int x, int y) {
        
        int count = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                count++;
            }
            xor >>= 1;
        }
        return count;
    }
}