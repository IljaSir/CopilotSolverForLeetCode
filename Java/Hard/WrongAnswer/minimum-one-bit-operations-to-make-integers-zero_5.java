class Solution {
    public int minimumOneBitOperations(int n) {
        
        return n == 0 ? 0 : (minimumOneBitOperations(n >> 1) << 1) | (n & 1) ^ 1;
    }
}