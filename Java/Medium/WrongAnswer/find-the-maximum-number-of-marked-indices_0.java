class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] * 2 <= nums[j]) {
                ans++;
                i++;
                j--;
            } else {
                i++;
            }
        }
        return ans;
    }
}