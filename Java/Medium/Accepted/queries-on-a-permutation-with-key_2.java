class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int pos = 0;
            for (int j = 0; j < p.length; j++) {
                if (p[j] == queries[i]) {
                    pos = j;
                    break;
                }
            }
            res[i] = pos;
            int tmp = p[pos];
            for (int j = pos; j > 0; j--) {
                p[j] = p[j - 1];
            }
            p[0] = tmp;
        }
        return res;
    }
}