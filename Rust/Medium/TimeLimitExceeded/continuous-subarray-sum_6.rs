impl Solution {
    pub fn check_subarray_sum(nums: Vec<i32>, k: i32) -> bool {
        

        let mut memo = vec![0; nums.len()];
        memo[0] = nums[0];
        for i in 1..nums.len() {
            memo[i] = memo[i - 1] + nums[i];
        }
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                let sum = memo[j] - memo[i] + nums[i];
                if sum == k || (k != 0 && sum % k == 0) {
                    return true;
                }
            }
        }
        false
    }
}