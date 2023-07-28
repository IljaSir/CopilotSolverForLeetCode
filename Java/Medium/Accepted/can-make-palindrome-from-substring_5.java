class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        
        List<Boolean> result = new ArrayList<>();
        int[] pre = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            pre[i + 1] = pre[i] ^ (1 << (s.charAt(i) - 'a'));
        }
        for (int[] query : queries) {
            int count = Integer.bitCount(pre[query[1] + 1] ^ pre[query[0]]);
            result.add(count / 2 <= query[2]);
        }
        return result;
    }
}