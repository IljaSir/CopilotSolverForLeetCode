class Solution {
    public int clumsy(int n) {
        
        int sum = 0;
        int cur = n;
        for (int i = 1; i < n; i++) {
            if (i % 4 == 1) {
                cur *= n - i;
            } else if (i % 4 == 2) {
                cur /= n - i;
            } else if (i % 4 == 3) {
                sum += cur;
                cur = n - i;
            } else {
                sum -= cur;
                cur = n - i;
            }
        }
        sum += cur;
        return sum;
    }
}