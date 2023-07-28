class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] count = new int[n];
        int res = n;
        for (int i = 0; i < n; i++) {
            if (blocks.charAt(i) == 'W') {
                count[i] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            count[i] += count[i - 1];
        }
        for (int i = 0; i + k <= n; i++) {
            int l = i, r = i + k - 1;
            int w = count[r] - (l == 0 ? 0 : count[l - 1]);
            res = Math.min(res, w);
        }
        return res;
    }
}