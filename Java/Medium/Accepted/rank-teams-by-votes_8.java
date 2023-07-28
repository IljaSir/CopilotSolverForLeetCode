class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] count = new int[n][26];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < 26; ++j)
                count[i][j] = 0;
        for (String vote : votes) {
            for (int i = 0; i < n; ++i)
                count[i][vote.charAt(i) - 'A'] -= 1;
        }
        Character[] teams = new Character[n];
        for (int i = 0; i < n; ++i)
            teams[i] = votes[0].charAt(i);
        Arrays.sort(teams, (a, b) -> {
            for (int i = 0; i < n; ++i) {
                if (count[i][a - 'A'] != count[i][b - 'A'])
                    return count[i][a - 'A'] - count[i][b - 'A'];
            }
            return a - b;
        });
        StringBuilder ans = new StringBuilder();
        for (char c : teams)
            ans.append(c);
        return ans.toString();
    }
}