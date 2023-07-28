class Solution {
    public int minSwaps(String s) {
        
        int n = s.length();
        int[] ones = new int[n];
        int[] zeros = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
            ones[i] = sum;
            zeros[i] = i - ones[i];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int onesCount = i == 0 ? ones[n - 1] : ones[n - 1] - ones[i - 1];
            int zerosCount = i == 0 ? zeros[n - 1] : zeros[n - 1] - zeros[i - 1];
            if (onesCount == zerosCount) {
                min = Math.min(min, onesCount);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}