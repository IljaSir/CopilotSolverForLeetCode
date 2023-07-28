class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int max = 0, sum = 0, n = customers.length;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        max = sum;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            if (grumpy[i - minutes] == 0) {
                sum -= customers[i - minutes];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}