class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        Set<Integer>[][] lang = new Set[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                if (lang[i][languages[i][j] - 1] == null) {
                    lang[i][languages[i][j] - 1] = new HashSet<>();
                }
                lang[i][languages[i][j] - 1].add(i);
            }
        }
        int[][] f = new int[friendships.length][2];
        for (int i = 0; i < friendships.length; i++) {
            f[i][0] = friendships[i][0] - 1;
            f[i][1] = friendships[i][1] - 1;
        }
        int[] langCount = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if (lang[j][i] != null) {
                    set.addAll(lang[j][i]);
                }
            }
            langCount[i] = set.size();
        }
        int min = m;
        for (int i = 0; i < friendships.length; i++) {
            int[] p = f[i];
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (lang[p[0]][j] != null && lang[p[1]][j] != null) {
                    c = Math.max(c, langCount[j]);
                }
            }
            min = Math.min(min, m - c);
        }
        return min;
    }
}