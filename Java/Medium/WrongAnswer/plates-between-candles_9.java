class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int n = s.length();
        int[] plates = new int[n];
        int[] candles = new int[n];
        int[] ans = new int[queries.length];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                sum++;
            }
            plates[i] = sum;
        }
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                sum++;
            }
            candles[i] = sum;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int left = q[0];
            int right = q[1];
            int p = plates[right] - (left == 0 ? 0 : plates[left - 1]);
            int c = candles[left] - (right == n - 1 ? 0 : candles[right + 1]);
            ans[i] = Math.max(0, p - c);
        }
        return ans;
    }
}