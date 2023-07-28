class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum2 = nums[i] + nums[j] + nums[k];
                if (sum2 == target) {
                    return sum2;
                } else if (sum2 < target) {
                    j++;
                } else {
                    k--;
                }
                if (Math.abs(sum2 - target) < diff) {
                    diff = Math.abs(sum2 - target);
                    sum = sum2;
                }
            }
        }
        return sum;
    }
}