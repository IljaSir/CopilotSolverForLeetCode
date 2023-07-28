class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int count = 0;
        for (int num : nums) {
            int c = 0;
            while (num > 0) {
                if ((num & 1) == 1) count++;
                num >>= 1;
                c++;
            }
            max = Math.max(max, c);
        }
        return count + max - 1;
    }
}