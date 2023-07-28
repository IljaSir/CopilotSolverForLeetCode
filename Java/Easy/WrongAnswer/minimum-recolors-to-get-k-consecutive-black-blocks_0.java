class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (blocks.charAt(i) == 'B' ? 1 : 0);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i + k <= n; i++) {
            int cnt = prefix[i + k] - prefix[i];
            res = Math.min(res, cnt + (k - cnt) / 2);
        }
        return res;
    }
}