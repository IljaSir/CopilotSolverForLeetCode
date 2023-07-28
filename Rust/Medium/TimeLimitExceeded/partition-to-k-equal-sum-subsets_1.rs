impl Solution {
    pub fn can_partition_k_subsets(nums: Vec<i32>, k: i32) -> bool {
        

        let sum: i32 = nums.iter().sum();
        if sum % k != 0 {
            return false;
        }
        let target = sum / k;
        let mut visited = vec![false; nums.len()];
        Solution::can_partition(&nums, k, target, 0, 0, &mut visited)
    }
    
    fn can_partition(nums: &Vec<i32>, k: i32, target: i32, start: usize, cur_sum: i32, visited: &mut Vec<bool>) -> bool {
        if k == 1 {
            return true;
        }
        if cur_sum == target {
            return Solution::can_partition(nums, k - 1, target, 0, 0, visited);
        }
        for i in start..nums.len() {
            if !visited[i] && cur_sum + nums[i] <= target {
                visited[i] = true;
                if Solution::can_partition(nums, k, target, i + 1, cur_sum + nums[i], visited) {
                    return true;
                }
                visited[i] = false;
            }
        }
        false
    }
}