class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        int[] friend = new int[m + 1];
        for (int i = 0; i < friendships.length; i++) {
            int[] f = friendships[i];
            friend[f[0]] |= (1 << f[1]);
            friend[f[1]] |= (1 << f[0]);
        }
        int[] cnt = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < languages[i - 1].length; j++) {
                cnt[languages[i - 1][j]]++;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= m; i++) {
            int[] cur = new int[n + 1];
            for (int j = 0; j < languages[i - 1].length; j++) {
                cur[languages[i - 1][j]]++;
            }
            int need = 0;
            for (int j = 1; j <= m; j++) {
                if ((friend[i] & (1 << j)) == 0) {
                    continue;
                }
                int max = 0;
                for (int k = 0; k < languages[j - 1].length; k++) {
                    max = Math.max(max, cur[languages[j - 1][k]]);
                }
                need += cnt[languages[j - 1][0]] - max;
            }
            ans = Math.min(ans, need);
        }
        return ans;
    }
}