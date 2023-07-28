class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] candles = new int[s.length()];
        int[] plates = new int[s.length()];
        int[] result = new int[queries.length];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            plates[i] = count;
        }
        count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '*') {
                count++;
            }
            candles[i] = count;
        }
        for (int i = 0; i < queries.length; i++) {
            result[i] = plates[queries[i][1]] - plates[queries[i][0]] - (candles[queries[i][0]] + candles[queries[i][1]] - 2);
        }
        return result;
    }
}