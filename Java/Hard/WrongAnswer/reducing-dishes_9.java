class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[] sum = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = satisfaction[i];
            if (i > 0) {
                sum[i] += sum[i - 1];
            }
        }
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (sum[i] >= 0) {
                res += sum[i];
            } else {
                break;
            }
        }
        return res;
    }
}