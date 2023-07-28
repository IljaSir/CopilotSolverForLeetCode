class Solution {
    public int minOperations(int[] nums) {
        
        int count = 0;
        int max = 0;
        for (int num : nums) {
            int tmp = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    count++;
                }
                num >>= 1;
                tmp++;
            }
            max = Math.max(max, tmp);
        }
        return count + max - 1;
    }
}