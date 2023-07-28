class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[31];
        for (int i = 0; i < 31; i++) {
            powers[i] = 1 << i;
        }
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int product = 1;
            for (int j = left; j <= right; j++) {
                product *= powers[j];
                if (product > 1000000007) {
                    product %= 1000000007;
                }
            }
            ret[i] = product;
        }
        return ret;
    }
}