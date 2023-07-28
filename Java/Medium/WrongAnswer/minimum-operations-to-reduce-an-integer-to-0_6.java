class Solution {
    public int minOperations(int n) {
        
        int ans = 0;
        int i = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans += i;
            }
            i <<= 1;
            n >>= 1;
        }
        return ans;
    }
}