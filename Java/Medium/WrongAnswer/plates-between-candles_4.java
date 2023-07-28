class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int[] candles = new int[s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                count++;
            }
            candles[i] = count;
        }
        for(int i = 0; i < queries.length; i++) {
            answer[i] = candles[queries[i][1]] - candles[queries[i][0]] - 2;
        }
        return answer;
    }
}