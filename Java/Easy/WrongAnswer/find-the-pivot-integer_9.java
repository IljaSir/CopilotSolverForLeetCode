class Solution {
    public int pivotInteger(int n) {
        
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            int sumLeft = sum(1, mid);
            int sumRight = sum(mid + 1, n);
            if (sumLeft == sumRight) {
                return mid;
            } else if (sumLeft < sumRight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    private int sum(int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}