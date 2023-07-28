class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[31];
        int[] products = new int[31];
        int[] answers = new int[queries.length];
        int j = 0;
        for (int i = 0; i < 31; i++) {
            powers[i] = (int) Math.pow(2, i);
        }
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int product = 1;
            for (j = left; j <= right; j++) {
                if (products[j] != 0) {
                    product *= products[j];
                } else {
                    product *= powers[j];
                }
            }
            answers[i] = product;
            products[left] = product;
        }
        return answers;
    }
}