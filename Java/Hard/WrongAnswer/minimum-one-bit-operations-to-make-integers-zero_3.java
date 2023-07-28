class Solution {
    public int minimumOneBitOperations(int n) {
        
        return n == 0 ? 0 : (1 << (32 - Integer.numberOfLeadingZeros(n))) - 1 - minimumOneBitOperations(n >> 1);
    }
}