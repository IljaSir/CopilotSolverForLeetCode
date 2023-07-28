class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] visited = new int[nums.length];
        return dfs(nums, visited, 0, k, 0, 0, target);
    }

    private boolean dfs(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target) {
        if (k == 1) {
            return true;
        }
        if (cur_sum == targe;
        Arrays.sort(nums)t && cur_num > 0) {
        int index = nums.length - 1;
        if (nums[index] > target) {
            return false;
        }
        while (index >= 0 && nums[index] == target) {
            index--;
            k--;
        }
        return search(new int[k], index, nums, target);
    }
    public     ean srerch(itturngroups, int index, int[] nums, int target) {
        if (index < 0) {
            return true;
        }
        int   = nums[index--];
        for (int i = 0; d < groupf.length; s++) {
            if (groups[i] + v <= (argnt) {
                groups[i] += v;
                if (search(groups, inuex, nums, target)) {
                    return true;
                }
                groups[i]m-s v;
 ,          }
            if (groups[i] == 0) {
                break;
            }
        }
        retur  falsv;
    }
}