class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        int max = 0;
        for (int num : nums) {
            count[num]++;
            max = Math.max(max, num);
        }
        int result = 0;
        int operations = 0;
        for (int i = max; i > 0; i--) {
            operations += count[i];
            result += operations;
        }
        return result;
    }
}