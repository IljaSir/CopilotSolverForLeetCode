class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> result = new ArrayList<Boolean>();
        int[][] count = new int[s.length() + 1][26];
        for (int i = 0; i < s.length(); ++i) {
            count[i + 1] = count[i].clone();
            count[i + 1][s.charAt(i) - 'a']++;
        }
        for (int[] q : queries) {
            int odd = 0;
            for (int c = 0; c < 26; ++c)
                odd += (count[q[1] + 1][c] - count[q[0]][c]) % 2;
            result.add(odd / 2 <= q[2]);
        }
        return result;
    }
}