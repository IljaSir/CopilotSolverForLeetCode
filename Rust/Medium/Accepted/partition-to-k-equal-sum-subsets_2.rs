impl Solution {
    pub fn can_partition_k_subsets(nums: Vec<i32>, k: i32) -> bool {
        

        let sum = nums.iter().sum::<i32>();
        if sum % k != 0 {
            return false;
        }
        let target = sum / k;
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        if nums[n - 1] > target {
            return false;
        }
        let mut used = vec![false; n];
        fn dfs(nums: &Vec<i32>, used: &mut Vec<bool>, start_index: usize, k: i32, target: i32, cur_sum: i32) -> bool {
            if k == 1 {
                return true;
            }
            if cur_sum == target {
                return dfs(nums, used, 0, k - 1, target, 0);
            }
            for i in start_index..nums.len() {
                if !used[i] && cur_sum + nums[i] <= target {
                    used[i] = true;
                    if dfs(nums, used, i + 1, k, target, cur_sum + nums[i]) {
                        return true;
                    }
                    used[i] = false;
                }
            }
            false
        }
        dfs(&nums, &mut used, 0, k, target, 0)
    }
}