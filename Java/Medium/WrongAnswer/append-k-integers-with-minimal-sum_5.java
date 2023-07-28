class Solution {
    public long minimalKSum(int[] nums, int k) {
        
        long sum = 0;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length && k > 0) {
            if (i == 0) {
                if (nums[i] > 1) {
                    sum += 1;
                    k--;
                }
            } else {
                if (nums[i] > nums[i - 1] + 1) {
                    sum += nums[i - 1] + 1;
                    k--;
                }
            }
            i++;
        }
        if (k > 0) {
            sum += nums[nums.length - 1] + k;
        }
        return sum;
    }
}