class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[32];
        int[] ans = new int[queries.length];
        int i = 0;
        while (n > 0) {
            powers[i++] = n;
            n = n & (n - 1);
        }
        i = 0;
        for (int[] q : queries) {
            long product = 1;
            for (int j = q[0]; j <= q[1]; j++) {
                product = (product * powers[j]) % 1000000007;
            }
            ans[i++] = (int) product;
        }
        return ans;
    }
}