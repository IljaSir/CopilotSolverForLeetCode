class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        int ans = 0;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
                if (Math.abs(sum - target) < diff) {
                    ans = sum;
                    diff = Math.abs(sum - target);
                }
            }
        }
        return ans;
    }
}