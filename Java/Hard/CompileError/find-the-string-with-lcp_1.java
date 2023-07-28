class Solution {
    public String findTheString(int[][] lcp) {
        
        int n = lcp.length;
        int[] cnt = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cnt[i] = Math.max(cnt[i], lcp[i][j]);
            }
        }
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = i;
        }
        Arrays.sort(pos, (a, b) -> cnt[b] - cnt[a]);
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[pos[i]] = i;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int j = p[i];
            if (j == 0) {
                ans[i] = cnt[0];
            } else {
                ans[i] = Math.max(lcp[pos[j - 1]][i], cnt[j]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) (ans[i] + 'a'));
        }
        return sb.toString();
    }
}