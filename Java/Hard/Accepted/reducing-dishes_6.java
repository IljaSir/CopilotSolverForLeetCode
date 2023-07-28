class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int max = 0;
        int sum = 0;
        int n = satisfaction.length;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > 0) {
                max += sum;
            } else {
                break;
            }
        }
        return max;
    }
}