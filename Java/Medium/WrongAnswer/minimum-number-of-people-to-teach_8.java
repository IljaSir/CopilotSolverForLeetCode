class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        
        int m = languages.length;
        int f = friendships.length;
        int[] lang = new int[m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < languages[i].length; j++) {
                lang[i + 1] |= 1 << (languages[i][j] - 1);
            }
        }
        int[] common = new int[f];
        for (int i = 0; i < f; i++) {
            common[i] = lang[friendships[i][0]] & lang[friendships[i][1]];
        }
        int ans = f;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < f; j++) {
                if (common[j] >> i == 0) {
                    cnt++;
                }
            }
            ans = Math.min(ans, cnt);
        }
        return ans;
    }
}