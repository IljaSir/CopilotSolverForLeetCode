class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int sum = 0;
        int max = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
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