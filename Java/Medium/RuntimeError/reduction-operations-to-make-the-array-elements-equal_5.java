class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        for (int num : nums) {
            count[num]++;
        }
        int sum = 0;
        for (int i = 50000; i >= 1; i--) {
            count[i] += count[i + 1];
            sum += count[i];
        }
        return sum;
    }
}