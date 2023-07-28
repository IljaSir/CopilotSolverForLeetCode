class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }
}