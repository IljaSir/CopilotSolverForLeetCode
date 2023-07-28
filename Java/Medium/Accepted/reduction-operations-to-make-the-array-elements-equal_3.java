class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        for (int num : nums) {
            count[num]++;
        }
        int res = 0, sum = 0;
        for (int i = 50000; i >= 0; i--) {
            if (count[i] > 0) {
                res += sum;
                sum += count[i];
            }
        }
        return res;
    }
}