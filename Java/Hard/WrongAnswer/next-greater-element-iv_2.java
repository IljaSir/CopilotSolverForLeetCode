class Solution {
    public int[] secondGreaterElement(int[] nums) {
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;
                }
            }
        }
        return res;
    }
}