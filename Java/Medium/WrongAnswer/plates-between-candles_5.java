class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] answer = new int[queries.length];
        int[] candles = new int[s.length()];
        int[] plates = new int[s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '|') {
                count++;
            }
            candles[i] = count;
        }
        count = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == '*') {
                count++;
            }
            plates[i] = count;
        }
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            if(left == right) {
                answer[i] = 0;
            } else {
                answer[i] = plates[left] + plates[right] - candles[right] + candles[left];
            }
        }
        return answer;
    }
}