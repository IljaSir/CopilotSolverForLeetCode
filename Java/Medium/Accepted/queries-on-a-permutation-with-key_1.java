class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] p = new int[m];
        for (int i = 0; i < m; i++) {
            p[i] = i + 1;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = 0;
            for (int j = 0; j < m; j++) {
                if (p[j] == queries[i]) {
                    index = j;
                    break;
                }
            }
            result[i] = index;
            int tmp = p[index];
            for (int j = index; j > 0; j--) {
                p[j] = p[j - 1];
            }
            p[0] = tmp;
        }
        return result;
    }
}