class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] count = new int[26][n];
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < n; j++) {
                count[votes[i].charAt(j) - 'A'][j]++;
            }
        }
        int[] index = new int[26];
        for (int i = 0; i < 26; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (count[a][i] != count[b][i]) {
                    return count[b][i] - count[a][i];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (count[index[i]][0] == 0) {
                break;
            }
            sb.append((char) (index[i] + 'A'));
        }
        return sb.toString();
    }
}