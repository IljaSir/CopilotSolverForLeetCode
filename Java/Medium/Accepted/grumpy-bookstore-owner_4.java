class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int max = 0;
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0)
                sum += customers[i];
        }
        int count = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1)
                count += customers[i];
        }
        max = count;
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1)
                count += customers[i];
            if (grumpy[i - minutes] == 1)
                count -= customers[i - minutes];
            max = Math.max(max, count);
        }
        return sum + max;
    }
}