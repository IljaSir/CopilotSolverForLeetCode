class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int max = 0;
        int sum = 0;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            if (i < minutes) {
                if (grumpy[i] == 1) {
                    sum2 += customers[i];
                }
            }
        }
        max = sum2;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                sum2 += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                sum2 -= customers[i - minutes];
            }
            max = Math.max(max, sum2);
        }
        return max + sum;
    }
}