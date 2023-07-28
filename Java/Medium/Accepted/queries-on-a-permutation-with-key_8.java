class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] res = new int[queries.length];
        int[] pos = new int[m];
        for (int i = 0; i < m; i++) {
            pos[i] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            int p = queries[i] - 1;
            res[i] = pos[p];
            for (int j = 0; j < m; j++) {
                if (pos[j] < pos[p]) {
                    pos[j]++;
                }
            }
            pos[p] = 0;
        }
        return res;
    }
}