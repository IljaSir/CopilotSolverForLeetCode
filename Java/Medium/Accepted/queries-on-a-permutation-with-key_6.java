class Solution {
    public int[] processQueries(int[] queries, int m) {
        
        int[] result = new int[queries.length];
        int[] permutation = new int[m];
        for (int i = 0; i < m; i++) {
            permutation[i] = i + 1;
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < m; j++) {
                if (permutation[j] == queries[i]) {
                    result[i] = j;
                    int temp = permutation[j];
                    for (int k = j; k > 0; k--) {
                        permutation[k] = permutation[k - 1];
                    }
                    permutation[0] = temp;
                    break;
                }
            }
        }
        return result;
    }
}