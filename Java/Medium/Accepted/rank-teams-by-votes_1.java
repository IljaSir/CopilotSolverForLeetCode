class Solution {
    public String rankTeams(String[] votes) {
        
        int n = votes[0].length();
        int[][] count = new int[26][n];
        for (String vote : votes) {
            for (int i = 0; i < n; i++) {
                count[vote.charAt(i) - 'A'][i]++;
            }
        }
        Character[] chars = new Character[n];
        for (int i = 0; i < n; i++) {
            chars[i] = votes[0].charAt(i);
        }
        Arrays.sort(chars, (a, b) -> {
            for (int i = 0; i < n; i++) {
                if (count[a - 'A'][i] != count[b - 'A'][i]) {
                    return count[b - 'A'][i] - count[a - 'A'][i];
                }
            }
            return a - b;
        });
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}