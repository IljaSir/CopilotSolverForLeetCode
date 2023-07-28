class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] count = new int[26][n + 1];
        for (int i = 0; i < 26; ++i) {
            count[i][0] = i;
        }
        for (String vote: votes) {
            for (int i = 0; i < n; ++i) {
                count[vote.charAt(i) - 'A'][i + 1]--;
            }
        }
        Arrays.sort(count, (a, b) -> {
            for (int i = 1; i < n + 1; ++i) {
                if (a[i] != b[i]) {
                    return a[i] - b[i];
                }
            }
            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append((char)(count[i][0] + 'A'));
        }
        return sb.toString();
    }
}