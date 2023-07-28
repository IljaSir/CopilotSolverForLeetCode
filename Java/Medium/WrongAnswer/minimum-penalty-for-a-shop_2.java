class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + (customers.charAt(i - 1) == 'Y' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int cur = prefix[i] + prefix[n] - prefix[i];
            if (min > cur) {
                min = cur;
                res = i;
            }
        }
        return res;
    }
}