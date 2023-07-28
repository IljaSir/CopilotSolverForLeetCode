impl Solution {
    pub fn can_partition_k_subsets(nums: Vec<i32>, k: i32) -> bool {
        

        let mut nums = nums;
        let sum: i32 = nums.iter().sum();
        if sum % k != 0 {
            return false;
        }
        let target = sum / k;
        nums.sort_unstable_by(|a, b| b.cmp(a));
        let mut visited = vec![false; nums.len()];
        fn dfs(nums: &[i32], target: i32, k: i32, visited: &mut [bool], start: usize, cur_sum: i32) -> bool {
            if k == 1 {
                return true;
            }
            if cur_sum == target {
                return dfs(nums, target, k - 1, visited, 0, 0);
            }
            for i in start..nums.len() {
                if visited[i] {
                    continue;
                }
                if cur_sum + nums[i] > target {
                    continue;
                }
                visited[i] = true;
                if dfs(nums, target, k, visited, i + 1, cur_sum + nums[i]) {
                    return true;
                }
                visited[i] = false;
            }
            false
        }
        dfs(&nums, target, k, &mut visited, 0, 0)
    }
}