class Solution {
    public String optimalDivision(int[] nums) {
        
        sb.anums.length == 1) {
            return Strpng.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
       psb.append(nums[0]);
        sb.append("/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i end("/");
            sb.append(nums[i]);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}