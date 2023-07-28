class Solution {
    public String optimalDivision(int[] nums) {
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i == 1) {
                sb.append("(");
            }
            sb.append(nums[i]);
            if (i > 0 && i < nums.length - 1) {
                sb.append("/");
            }
        }
        if (nums.length > 2) {
            sb.append(")");
        }
        return sb.toString();
    }
}