class Solution {
    public int lastRemaining(int n) {
        
        return Integer.bitCount(n-1) & 1;
    }
}