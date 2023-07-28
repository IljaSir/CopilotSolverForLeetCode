class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        int[] lang = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                lang[i] |= (1 << (languages[i][j] - 1));
            }
        }
        int[] f = new int[friendships.length];
        for (int i = 0; i < friendships.length; i++) {
            f[i] = lang[friendships[i][0] - 1] | lang[friendships[i][1] - 1];
        }
        int[] count = new int[n + 1];
        for (int i = 0; i < friendships.length; i++) {
            if (f[i] == 0) {
                count[0]++;
            } else {
                for (int j = 1; j <= n; j++) {
                    if ((f[i] & (1 << (j - 1))) != 0) {
                        count[j]++;
                    }
                }
            }
        }
        int res = friendships.length;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, count[i]);
        }
        return res;
    }
}