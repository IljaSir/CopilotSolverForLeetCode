class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] result = new int[queries.length];
        int[] P = new int[m];
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            int pos = 0;
            for (int j = 0; j < m; j++) {
                if (P[j] == queries[i]) {
                    pos = j;
                    break;
                }
            }
            result[i] = pos;
            int temp = P[pos];
            for (int j = pos; j > 0; j--) {
                P[j] = P[j - 1];
            }
            P[0] = temp;
        }
        return result;
    }
}