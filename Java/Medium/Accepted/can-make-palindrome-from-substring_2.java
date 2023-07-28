class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        int[][] count = new int[s.length()+1][26];
        for (int i = 0; i < s.length(); i++) {
            count[i+1] = Arrays.copyOf(count[i], 26);
            count[i+1][s.charAt(i)-'a']++;
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] q : queries) {
            int odd = 0;
            for (int i = 0; i < 26; i++) {
                odd += (count[q[1]+1][i] - count[q[0]][i]) % 2;
            }
            res.add(odd / 2 <= q[2]);
        }
        return res;
    }
}