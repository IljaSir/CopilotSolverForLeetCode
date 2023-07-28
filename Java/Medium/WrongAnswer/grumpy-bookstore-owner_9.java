class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] grumpyCustomers = new int[n];
        int grumpyCustomersSum = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 1) {
                grumpyCustomers[i] = customers[i];
                grumpyCustomersSum += customers[i];
            }
        }
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + grumpyCustomers[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + grumpyCustomers[i + 1];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int left = i - minutes >= 0 ? prefix[i - minutes] : 0;
            int right = i + minutes < n ? suffix[i + minutes] : 0;
            max = Math.max(max, grumpyCustomersSum - left - right);
        }
        return max;
    }
}