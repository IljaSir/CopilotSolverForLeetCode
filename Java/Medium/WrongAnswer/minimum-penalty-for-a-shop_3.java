class Solution {
    public int bestClosingTime(String customers) {
        
        int n = customers.length();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = customers.charAt(i) == 'Y' ? 1 : 0;
        }
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= n; i++) {
            int cur = pre[i] + (n - i - (pre[n] - pre[i]));
            if (cur < min) {
                min = cur;
                res = i;
            }
        }
        return res;
    }
}