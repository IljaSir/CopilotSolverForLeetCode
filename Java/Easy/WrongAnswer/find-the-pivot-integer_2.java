class Solution {
    public int pivotInteger(int n) {
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return -1;
        }
        int pivot = 0;
        int leftSum = 0;
        for (int i = 1; i <= n; i++) {
            pivot = i;
            leftSum += i;
            if (leftSum == sum / 2) {
                return pivot;
            }
        }
        return -1;
    }
}