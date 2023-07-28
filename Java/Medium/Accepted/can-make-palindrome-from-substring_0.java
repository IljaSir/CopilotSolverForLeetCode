class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        int[][] count = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                count[i][j] = count[i - 1][j];
            }
            count[i][s.charAt(i - 1) - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                if ((count[query[1] + 1][i] - count[query[0]][i]) % 2 == 1) {
                    odd++;
                }
            }
            res.add(odd / 2 <= query[2]);
        }
        return res;
    }
}