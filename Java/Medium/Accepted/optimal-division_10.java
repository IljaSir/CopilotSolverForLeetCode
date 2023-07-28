class Solution {
    public String optimalDivision(int[] nums) {
        
        int n = nums.length;
        if (n == 1) {
            return String.valueOf(nums[0]);
        }
        if (n == 2) {
            return String.valueOf(nums[0]) + "/" + String.valueOf(nums[1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(nums[0]));
        sb.append("/(");
        sb.append(String.valueOf(nums[1]));
        for (int i = 2; i < n; i++) {
            sb.append("/");
            sb.append(String.valueOf(nums[i]));
        }
        sb.append(")");
        return sb.toString();
    }
}