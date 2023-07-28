class Solution {
    public int minFlipsMonoIncr(String s) {
        
        int n = s.length();
        int[] ones = new int[n];
        int[] zeros = new int[n];
        ones[0] = (s.charAt(0) == '1') ? 1 : 0;
        zeros[0] = (s.charAt(0) == '0') ? 1 : 0;
        for (int i = 1; i < n; i++) {
            ones[i] = ones[i - 1] + ((s.charAt(i) == '1') ? 1 : 0);
            zeros[i] = zeros[i - 1] + ((s.charAt(i) == '0') ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = n - 1 - i;
            int leftOnes = (left > 0) ? ones[left - 1] : 0;
            int leftZeros = (left > 0) ? zeros[left - 1] : 0;
            int rightOnes = ones[n - 1] - ones[i];
            int rightZeros = zeros[n - 1] - zeros[i];
            ans = Math.min(ans, leftZeros + rightOnes);
            ans = Math.min(ans, leftOnes + rightZeros);
        }
        return ans;
    }
}