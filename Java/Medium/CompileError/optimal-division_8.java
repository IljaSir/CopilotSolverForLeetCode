class Solution {
    public String optimalDivision(int[] nums) {
        
        if (nums.length == 1) return String.valueOf(nums[0]);
        if (nums.length == 2) return nums[0] + "/" + nums[1];
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        sb.append(nums[1]);
        f
        return sb.toString();
    }
}