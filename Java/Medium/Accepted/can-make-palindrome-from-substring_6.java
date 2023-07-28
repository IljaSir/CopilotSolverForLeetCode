class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        int[][] count = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                count[i + 1][j] = count[i][j];
            }
            count[i + 1][s.charAt(i) - 'a']++;
        }
        for (int[] query : queries) {
            int odd = 0;
            for (int j = 0; j < 26; j++) {
                if ((count[query[1] + 1][j] - count[query[0]][j]) % 2 != 0) {
                    odd++;
                }
            }
            result.add(odd / 2 <= query[2]);
        }
        return result;
    }
}