class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        Set<Integer>[] lang = new Set[m];
        for (int i = 0; i < m; i++) {
            lang[i] = new HashSet<>();
            for (int j = 0; j < languages[i].length; j++) {
                lang[i].add(languages[i][j]);
            }
        }
        int[] count = new int[n + 1];
        int res = m;
        for (int[] f : friendships) {
            int x = f[0] - 1, y = f[1] - 1;
            if (lang[x].equals(lang[y])) continue;
            for (int i = 1; i <= n; i++) {
                if (lang[x].contains(i) || lang[y].contains(i)) {
                    count[i]++;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, m - count[i]);
        }
        return res;
    }
}