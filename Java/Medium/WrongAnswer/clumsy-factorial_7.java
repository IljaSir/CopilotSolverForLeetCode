class Solution {
    public int clumsy(int n) {
        
        int[] op = new int[] {1, 2, 2, -1};
        int res = n;
        for (int i = 0; i < n - 1; i++) {
            if (i % 4 == 0) {
                res *= (n - i - 1);
            } else if (i % 4 == 1) {
                res /= (n - i - 1);
            } else if (i % 4 == 2) {
                res += (n - i - 1);
            } else {
                res += op[i % 4] * (n - i - 1);
            }
        }
        return res;
    }
}