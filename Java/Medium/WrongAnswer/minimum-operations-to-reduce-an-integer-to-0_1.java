class Solution {
    public int minOperations(int n) {
        
        int ans = 0;
        while (n > 0) {
            ans += n & 1;
            n >>= 1;
        }
        return ans;
    }
}