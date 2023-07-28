class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] ones = new int[n+1];
        for (int i = 1; i <= n; i++) {
            ones[i] = ones[i-1] + (s.charAt(i-1) == '1' ? 1 : 0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int flips = ones[i] + (n - i - (ones[n] - ones[i]));
            min = Math.min(min, flips);
        }
        return min;
    }
}