class Solution {
    public String findDifferentBinaryString(String[] nums) {
        
        int n = nums.length;
        int x = 0;
        for (String s : nums) {
            x ^= Integer.parseInt(s, 2);
        }
        return String.format("%0" + n + "d", Integer.parseInt(Integer.toBinaryString(x)));
    }
}