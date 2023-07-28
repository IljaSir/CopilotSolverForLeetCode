class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] plates = new int[s.length()];
        int[] candles = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                plates[i] = plates[i - 1];
                candles[i] = candles[i - 1];
            }
            if (s.charAt(i) == '*') {
                plates[i]++;
            } else {
                candles[i]++;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = query[0];
            int right = query[1];
            int platesCount = plates[right];
            if (left > 0) {
                platesCount -= plates[left - 1];
            }
            int candlesCount = candles[right];
            if (left > 0) {
                candlesCount -= candles[left - 1];
            }
            res[i] = platesCount - candlesCount;
        }
        return res;
    }
}