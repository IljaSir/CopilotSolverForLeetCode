class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int res = 0;
        int sum = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > 0) {
                res += sum;
            } else {
                break;
            }
        }
        return res;
    }
}