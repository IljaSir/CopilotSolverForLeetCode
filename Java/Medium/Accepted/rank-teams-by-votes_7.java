class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] counts = new int[n][26];
        for (String vote: votes) {
            for (int i = 0; i < n; i++) {
                counts[i][vote.charAt(i) - 'A']++;
            }
        }
        Character[] rank = new Character[n];
        for (int i = 0; i < n; i++) {
            rank[i] = votes[0].charAt(i);
        }
        Arrays.sort(rank, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (counts[i][a - 'A'] != counts[i][b - 'A']) {
                    return counts[i][b - 'A'] - counts[i][a - 'A'];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (char c: rank) {
            sb.append(c);
        }
        return sb.toString();
    }
}