class Solution {
    public String rankTeams(String[] votes) {
        
        int len = votes[0].length();
        int[][] count = new int[len][26];
        for (int i = 0; i < len; i++) {
            for (String vote : votes) {
                count[i][vote.charAt(i) - 'A']++;
            }
        }
        Character[] chars = new Character[len];
        for (int i = 0; i < len; i++) {
            chars[i] = votes[0].charAt(i);
        }
        Arrays.sort(chars, (a, b) -> {
            for (int i = 0; i < len; i++) {
                if (count[i][a - 'A'] != count[i][b - 'A']) {
                    return count[i][b - 'A'] - count[i][a - 'A'];
                }
            }
            return a - b;
        });
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c);
        }
        return sb.toString();
    }
}