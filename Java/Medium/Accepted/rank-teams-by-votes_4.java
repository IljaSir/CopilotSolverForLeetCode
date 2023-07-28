class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes.length;
        int m = votes[0].length();
        int[][] count = new int[m][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                count[j][votes[i].charAt(j) - 'A']++;
            }
        }
        Character[] teams = new Character[m];
        for (int i = 0; i < m; i++) {
            teams[i] = votes[0].charAt(i);
        }
        Arrays.sort(teams, (t1, t2) -> {
            for (int i = 0; i < m; i++) {
                if (count[i][t1 - 'A'] != count[i][t2 - 'A']) {
                    return count[i][t2 - 'A'] - count[i][t1 - 'A'];
                }
            }
            return t1 - t2;
        });
        StringBuilder sb = new StringBuilder();
        for (char c : teams) {
            sb.append(c);
        }
        return sb.toString();
    }
}