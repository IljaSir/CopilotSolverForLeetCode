class Solution {
    public int totalHammingDistance(int[] nums) {
        
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            total += count * (nums.length - count);
        }
        return total;
    }
}