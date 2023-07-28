class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[n - 1];
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    int k0 = k - 1;
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else if (sum < target) {
                    int j0 = j + 1;
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}