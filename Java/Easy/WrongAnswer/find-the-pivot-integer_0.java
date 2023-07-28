class Solution {
    public int pivotInteger(int n) {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return -1;
        }
        int left = 0;
        for (int i = 1; i <= n; i++) {
            if (left == sum - left - i) {
                return i;
            }
            left += i;
        }
        return -1;
    }
}