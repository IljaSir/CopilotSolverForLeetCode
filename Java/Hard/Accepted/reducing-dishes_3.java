class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int res = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0 && satisfaction[i] + sum > 0; i--) {
            sum += satisfaction[i];
            res += sum;
        }
        return res;
    }
}