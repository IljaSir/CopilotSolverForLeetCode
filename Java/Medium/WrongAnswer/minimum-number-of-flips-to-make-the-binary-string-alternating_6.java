class Solution {
    public int minFlips(String s) {
        
        int n = s.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) - '0' != i) {
                    count++;
                }
                i = 1 - i;
            }
            min = Math.min(min, count);
        }
        return min;
    }
}