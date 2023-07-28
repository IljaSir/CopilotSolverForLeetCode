impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = 0;
        dp[1] = 0;
        for i in 2..nums.len() {
            let mut min = dp[i-1];
            if nums[i] > nums[i-1] {
                min = min.min(dp[i-2]);
            }
            if nums[i] > nums[i-2] {
                min = min.min(dp[i-3]);
            }
            dp[i] = min + 1;
        }
        dp[nums.len()-1] as i64
    }
}