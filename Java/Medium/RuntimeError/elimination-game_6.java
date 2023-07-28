class Solution {
    public int lastRemaining(int n) {
        
        return 2 * (1 + n / 2 - lastRemaining(n / 2));
    }
}