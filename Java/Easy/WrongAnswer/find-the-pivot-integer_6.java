class Solution {
    public int pivotInteger(int n) {
        
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = sum + i;
        }
        int left = 0;
        int right = sum;
        for (int i = 1; i <= n; i++) {
            left = left + i;
            right = right - i;
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}