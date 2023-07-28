class Solution {
    public int[] productQueries(int n, int[][] queries) {
        
        int[] powers = new int[(int) Math.ceil(Math.log(n) / Math.log(2))];
        int index = 0;
        while (n > 0) {
            int pow = 1 << index;
            powers[index++] = pow;
            n -= pow;
        }
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long answer = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                answer = (answer * powers[j]) % (1000000007);
            }
            answers[i] = (int) answer;
        }
        return answers;
    }
}