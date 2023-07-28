class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] result = new int[queries.length];
        int[] candles = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                candles[i] = count++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = candles[query[1]] - candles[query[0]] - 1;
        }
        return result;
    }
}