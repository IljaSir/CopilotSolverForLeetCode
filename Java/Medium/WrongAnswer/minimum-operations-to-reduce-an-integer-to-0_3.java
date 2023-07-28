class Solution {
    public int minOperations(int n) {
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(n - 2 * i - 1);
        }
        return res / 2;
    }
}