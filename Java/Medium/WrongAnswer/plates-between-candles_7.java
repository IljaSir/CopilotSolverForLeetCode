class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] result = new int[queries.length];
        int[] plates = new int[s.length()];
        int[] candles = new int[s.length()];
        int plate = 0;
        int candle = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '*'){
                plate++;
            }
            plates[i] = plate;
        }
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i) == '|'){
                candle++;
            }
            candles[i] = candle;
        }
        for(int i = 0; i < queries.length; i++){
            result[i] = plates[queries[i][1]] - plates[queries[i][0]] - candles[queries[i][1]] + candles[queries[i][0]];
        }
        return result;
    }
}