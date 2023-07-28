class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> ans = new ArrayList<>();
        int[][] pre = new int[s.length() + 1][26];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                pre[i][j] = pre[i - 1][j];
            }
            pre[i][s.charAt(i - 1) - 'a']++;
        }
        for (int[] q : queries) {
            int odd = 0;
            for (int j = 0; j < 26; j++) {
                odd += (pre[q[1] + 1][j] - pre[q[0]][j]) % 2;
            }
            ans.add(odd / 2 <= q[2]);
        }
        return ans;
    }
}