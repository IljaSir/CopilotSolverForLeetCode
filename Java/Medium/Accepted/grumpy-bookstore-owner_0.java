class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        int n = customers.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;
            }
        }
        int cur = 0;
        for (int i = 0; i < minutes; i++) {
            cur += customers[i];
        }
        int max = cur;
        for (int i = minutes; i < n; i++) {
            cur = cur - customers[i - minutes] + customers[i];
            max = Math.max(max, cur);
        }
        return ans + max;
    }
}