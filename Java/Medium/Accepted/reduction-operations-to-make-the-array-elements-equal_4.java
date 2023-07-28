class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        for (int num : nums) {
            count[num]++;
        }
        int ans = 0;
        int sum = 0;
        for (int i = 50000; i >= 1; i--) {
            if (count[i] > 0) {
                ans += sum;
                sum += count[i];
            }
        }
        return ans;
    }
}