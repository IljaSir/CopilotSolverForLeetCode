class Solution {
    public int pivotInteger(int n) {
        
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        int leftSum = 0;
        for(int i = 1; i <= n; i++) {
            if(2 * leftSum == sum - i) {
                return i;
            }
            leftSum += i;
        }
        return -1;
    }
}