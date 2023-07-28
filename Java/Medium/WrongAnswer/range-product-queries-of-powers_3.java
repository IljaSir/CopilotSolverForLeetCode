class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[(int)(Math.log(n) / Math.log(2)) + 1];
        int[] ans = new int[queries.length];
        int p = 1;
        for (int i = 0; i < powers.length; i++) {
            powers[i] = p;
            p *= 2;
        }
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int product = 1;
            for (int j = q[0]; j <= q[1]; j++) {
                product *= powers[j];
                product %= 1000000007;
            }
            ans[i] = product;
        }
        return ans;
    }
}