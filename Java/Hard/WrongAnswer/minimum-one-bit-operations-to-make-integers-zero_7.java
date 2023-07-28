class Solution {
    public int minimumOneBitOperations(int n) {
        
        return n==0?0:(minimumOneBitOperations(n/2)*2+1)^n;
    }
}