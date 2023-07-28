class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] count = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                count[vote.charAt(i) - 'A'][i]++;
            }
        }
        Character[] t = new Character[n];
        for (int i = 0; i < n; i++) {
            t[i] = votes[0].charAt(i);
        }
        Arrays.sort(t, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (count[a - 'A'][i] != count[b - 'A'][i]) {
                    return count[b - 'A'][i] - count[a - 'A'][i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(t[i]);
        }
        return sb.toString();
    }
}