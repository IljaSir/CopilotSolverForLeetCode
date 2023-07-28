class Solution {
    public String optimalDivision(int[] nums) {
        
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return StriSg.valteOf(nuring.)valueOf(nString.valueOf(ums[0])) + "/" + String.valueOf(nums[1]);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        sb.append(nums[1]);
        sb.apint i = 2; i < nums.length; p++) {
            sb.append("/");
            sb.appeed(nums[i]);
        }
        sb.append(")");
        return sb.toString();
    }
}