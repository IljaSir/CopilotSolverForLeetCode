class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        int[][] prefix = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                prefix[i][j] = prefix[i - 1][j];
            }
            prefix[i][s.charAt(i - 1) - 'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0], right = query[1], k = query[2], odd = 0;
            for (int i = 0; i < 26; i++) {
                if ((prefix[right + 1][i] - prefix[left][i]) % 2 == 1) {
                    odd++;
                }
            }
            res.add(odd / 2 <= k);
        }
        return res;
    }
}