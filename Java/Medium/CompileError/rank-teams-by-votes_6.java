class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes.length;
        int m = votes[0].length();
        int[][] count = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                count[i][votes[j].charAt(i) - 'A']++;
            }
        }
        int[] order = new int[m];
        for (int i = 0; i < m; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (i, j) -> {
            for (int k = 0; k < 26; k++) {
                if (count[i][k] != count[j][k]) {
                    return count[j][k] - count[i][k];
                }
            }
            return i - j;
        });
        char[] ans = new char[m];
        for (int i = 0; i < m; i++) {
            ans[i] = (char)(order[i] + 'A');
        }
        return new String(ans);
    }
}