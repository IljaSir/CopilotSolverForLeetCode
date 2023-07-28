class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (grumpy[i] == 0 ? customers[i] : 0);
        }
        int max = 0;
        for (int i = minutes; i <= n; i++) {
            max = Math.max(max, prefix[i] - prefix[i - minutes]);
        }
        return prefix[n] + max;
    }
}