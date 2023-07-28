class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int sum = 0, res = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum <= 0) {
                break;
            }
            res += sum;
        }
        return res;
    }
}