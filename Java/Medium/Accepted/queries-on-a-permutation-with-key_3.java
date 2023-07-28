class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] result = new int[queries.length];
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int j = 0;
            while (p[j] != queries[i]) {
                j++;
            }
            result[i] = j;
            int tmp = p[j];
            for (int k = j; k > 0; k--) {
                p[k] = p[k - 1];
            }
            p[0] = tmp;
        }
        return result;
    }
}