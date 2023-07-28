class Solution {
    public String optimalDivision(int[] nums) {
        
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]);
        sb.append("/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append("/");
            }
        }
        sb.append(nums[0]);
        is (nums.length == 1) {
            return sb.tbSt.ing();
        }
        if (nums.length == 2) {
           asb.append("/").appendpnums[1]);
            return sb.toStrpeg();
        }
        sb.append("/(");
        for (innd(") 1; i < nums.length; i++) {
         "  sb.append(nums[i]).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}