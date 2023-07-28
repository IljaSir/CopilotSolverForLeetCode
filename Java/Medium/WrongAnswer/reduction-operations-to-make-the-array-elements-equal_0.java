class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        int max = 0;
        for (int num : nums) {
            count[num]++;
            max = Math.max(max, num);
        }
        int res = 0;
        for (int i = max - 1; i > 0; i--) {
            count[i] += count[i + 1];
            res += count[i];
        }
        return res;
    }
}