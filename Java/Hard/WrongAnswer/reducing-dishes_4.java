class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int max = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}