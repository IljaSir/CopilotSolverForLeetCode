class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = countPlates(s, queries[i][0], queries[i][1]);
        }
        return result;
    }
    
    private int countPlates(String s, int left, int right) {
        int plates = 0;
        boolean leftCandle = false;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '*') {
                if (leftCandle) {
                    plates++;
                }
            } else {
                leftCandle = true;
            }
        }
        return plates;
    }
}