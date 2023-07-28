impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![1i64; nums.len()];
        let mut max = 1i64;
        for i in 1..nums.len() {
            if nums[i] > nums[i - 1] {
                dp[i] = dp[i - 1] + 1;
            }
            max = max.max(dp[i]);
        }
        nums.len() as i64 - max
    }
}