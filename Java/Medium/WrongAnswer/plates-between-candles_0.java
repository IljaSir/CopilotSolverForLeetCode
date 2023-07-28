class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int count = 0;
            for (int j = left; j <= right; j++) {
                if (s.charAt(j) == '*') {
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}