class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int result = 0;
        int total = 0;
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] == 0) continue;
            total += count[i];
            result += total - count[i];
        }
        return result;
    }
}