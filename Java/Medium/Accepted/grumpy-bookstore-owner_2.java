class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int sum = 0;
        int max = 0;
        int temp = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                temp += customers[i];
            }
        }
        max = temp;
        for (int i = minutes; i < customers.length; i++) {
            if (grumpy[i] == 1) {
                temp += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                temp -= customers[i - minutes];
            }
            max = Math.max(max, temp);
        }
        return sum + max;
    }
}