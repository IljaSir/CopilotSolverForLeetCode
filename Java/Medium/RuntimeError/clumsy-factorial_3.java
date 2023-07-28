class Solution {
    public int clumsy(int n) {
        
        if (n < 4) {
            return n;
        }
        int res = n * (n - 1) / (n - 2) + (n - 3);
        n -= 4;
        while (n > 0) {
            res -= n * (n - 1) / (n - 2);
            if (n - 3 > 0) {
                res += n - 3;
            }
            n -= 4;
        }
        return res;
    }
}