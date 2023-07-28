class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int ans = 0;
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += satisfaction[i];
            if (sum > 0) {
                ans += sum;
            } else {
                break;
            }
        }
        return ans;
    }
}