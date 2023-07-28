class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        for (int n : nums) {
            count[n]++;
        }
        int ans = 0;
        int sum = 0;
        for (int i = 50000; i >= 1; i--) {
            sum += count[i];
            ans += sum;
        }
        return ans;
    }
}