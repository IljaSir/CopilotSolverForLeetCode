class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int sum = 0;
        int current = 0;
        int result = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            current += satisfaction[i];
            if (current > 0) {
                sum += current;
                result = Math.max(result, sum);
            } else {
                break;
            }
        }
        return result;
    }
}