class Solution {
    public int destroyTargets(int[] nums, int space) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] cnt = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int j = i, c = 0;
            while (j < n && nums[j] - nums[i] <= space) {
                j++;
                c++;
            }
            max = Math.max(max, c);
        }
        return max;
    }
}