class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        int[] ans = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            q[i] = f(queries[i]);
        }
        for (int i = 0; i < w.length; i++) {
            w[i] = f(words[i]);
        }
        Arrays.sort(w);
        for (int i = 0; i < q.length; i++) {
            ans[i] = w.length - binarySearch(w, q[i]);
        }
        return ans;
    }
    
    private int binarySearch(int[] w, int q) {
        int l = 0;
        int r = w.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (w[m] <= q) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
    
    private int f(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        int ans = 1;
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}