class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[32];
        int index = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers[index] = 1 << index;
            }
            index++;
            n >>= 1;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int product = 1;
            for (int j = query[0]; j <= query[1]; j++) {
                product *= powers[j];
            }
            res[i] = product;
        }
        return res;
    }
}