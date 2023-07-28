class Solution {
    public int pivotInteger(int n) {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return -1;
        }
        int half = sum / 2;
        int left = 0;
        for (int i = 1; i <= n; i++) {
            left += i;
            if (left == half) {
                return i;
            }
        }
        return -1;
    }
}