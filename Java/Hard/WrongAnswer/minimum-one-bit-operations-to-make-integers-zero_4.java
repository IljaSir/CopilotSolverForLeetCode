class Solution {
    public int minimumOneBitOperations(int n) {
        
        if (n == 0) {
            return 0;
        }
        int res = 0;
        int i = 30;
        while (i >= 0) {
            if ((n & (1 << i)) != 0) {
                res = res + (1 << (i + 1)) - 1;
            }
            i--;
        }
        return res;
    }
}