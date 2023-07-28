class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] zeros = new int[n + 1];
        int[] ones = new int[n + 1];
        for (int i = 0; i < n; i++) {
            zeros[i + 1] = zeros[i];
            ones[i + 1] = ones[i];
            if (s.charAt(i) == '0') {
                zeros[i + 1]++;
            } else {
                ones[i + 1]++;
            }
        }
        int result = n;
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, zeros[i] + ones[n] - ones[i]);
        }
        return result;
    }
}