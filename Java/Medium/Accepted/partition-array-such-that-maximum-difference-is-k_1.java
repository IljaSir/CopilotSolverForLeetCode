class Solution {
    public int partitionArray(int[] nums, int k) {
        
        if (nums.length == 1) {
            return 1;
        }
        Arrays.sort(nums);
        int count = 1;
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num - min <= k && num - max <= k) {
                max = Math.max(max, num);
                min = Math.min(min, num);
            } else {
                count++;
                max = num;
                min = num;
            }
        }
        return count;
    }
}