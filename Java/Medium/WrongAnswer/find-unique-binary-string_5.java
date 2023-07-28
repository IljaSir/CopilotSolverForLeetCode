class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int mask = (1 << n) - 1;
        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num, 2);
        }
        return Integer.toBinaryString(mask ^ sum);
    }
}