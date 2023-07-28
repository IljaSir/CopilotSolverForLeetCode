class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        int[][] counts = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                counts[i + 1][j] = counts[i][j];
            }
            counts[i + 1][s.charAt(i) - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int odd = 0;
            for (int j = 0; j < 26; j++) {
                odd += (counts[query[1] + 1][j] - counts[query[0]][j]) % 2;
            }
            res.add(odd / 2 <= query[2]);
        }
        return res;
    }
}