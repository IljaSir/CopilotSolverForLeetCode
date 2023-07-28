class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int max = 1 << n;
        int mask = max - 1;
        int val = 0;
        for (String num : nums) {
            val |= Integer.parseInt(num, 2);
        }
        int diff = mask ^ val;
        return String.format("%" + n + "s", Integer.toBinaryString(diff)).replace(' ', '0');
    }
}