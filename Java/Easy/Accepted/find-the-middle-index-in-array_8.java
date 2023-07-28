class Solution {
    public int findMiddleIndex(int[] nums) {
        
        int i = 0;
        int sum = 0;
        int leftSum = 0;
        for (int n : nums)
            sum += n;
        while (i < nums.length) {
            if (leftSum == sum - nums[i] - leftSum)
                return i;
            leftSum += nums[i];
            i++;
        }
        return -1;
    }
}