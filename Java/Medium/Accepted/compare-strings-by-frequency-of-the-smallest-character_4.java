class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (q[i] < w[j]) {
                    ans[i]++;
                }
            }
        }
        return ans;
    }
    private int f(String s) {
        char c = s.charAt(0);
        int cnt = 1;
        for (int i = 1; i < s.length(); i++) {
            if (c > s.charAt(i)) {
                c = s.charAt(i);
                cnt = 1;
            } else if (c == s.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}