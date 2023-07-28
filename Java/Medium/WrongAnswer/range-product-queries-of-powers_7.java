class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        List<Integer> powers = new ArrayList<>();
        int[] ans = new int[queries.length];
        int product = 1;
        for(int i = 0; i < 31; i++) {
            if((n & (1 << i)) != 0) {
                powers.add(i);
                product = (product * (1 << i)) % 1000000007;
            }
        }
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int leftPower = powers.get(left);
            int rightPower = powers.get(right);
            int product2 = 1;
            for(int j = leftPower; j <= rightPower; j++) {
                product2 = (product2 * (1 << j)) % 1000000007;
            }
            ans[i] = (product / product2) % 1000000007;
        }
        return ans;
    }
}