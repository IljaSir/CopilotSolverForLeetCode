class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < queries.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < words.length; i++) {
            w[i] = f(words[i]);
        }
        Arrays.sort(w);
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int n = q[i];
            int l = 0;
            int r = words.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (w[m] <= n) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            res[i] = words.length - l;
        }
        return res;
    }
    
    private int f(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                return cnt[i];
            }
        }
        return 0;
    }
}