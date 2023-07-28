class Solution {
    public int maximizeGreatness(int[] nums) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            suffix[i] = Math.max(suffix[i + 1], nums[i]);
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (i < n - 1 && nums[i] < suffix[i + 1]) {
                res++;
            }
        }
        return res;
    }
}