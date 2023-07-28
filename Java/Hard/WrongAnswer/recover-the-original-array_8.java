class Solution {
    public int[] recoverArray(int[] nums) {
        
        int n = nums.length / 2;
        Arrays.sort(nums);
        int k = nums[n] - nums[0];
        int[] arr = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = nums[j] + k;
            j += 2;
        }
        return arr;
    }
}