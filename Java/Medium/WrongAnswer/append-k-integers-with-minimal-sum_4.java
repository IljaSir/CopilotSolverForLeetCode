class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        Arrays.sort(nums);
        int i = 0;
        while (k > 0) {
            if (i == nums.length - 1) {
                sum += k;
                break;
            }
            if (nums[i + 1] - nums[i] > 1) {
                int count = Math.min(k, nums[i + 1] - nums[i] - 1);
                sum += count * (nums[i] + 1);
                k -= count;
            }
            i++;
        }
        return sum;
    }
}