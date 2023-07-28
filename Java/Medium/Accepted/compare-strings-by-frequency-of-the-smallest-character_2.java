class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i = 0; i < q.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < w.length; i++) {
            w[i] = f(words[i]);
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < q.length; i++) {
            for (int j = 0; j < w.length; j++) {
                if (q[i] < w[j]) {
                    res[i]++;
                }
            }
        }
        return res;
    }

    private int f(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        char t = c[0];
        int res = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == t) {
                res++;
            } else {
                break;
            }
        }
        return res;
    }
}