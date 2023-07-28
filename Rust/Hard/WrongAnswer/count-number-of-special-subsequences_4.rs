impl Solution {
    pub fn count_special_subsequences(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 3];
        let mut modd = 1_000_000_007;
        for i in 0..nums.len() {
            let idx = nums[i] as usize;
            if idx == 0 {
                dp[0] = (dp[0] * 2 + 1) % modd;
            } else if idx == 1 {
                dp[1] = (dp[1] * 2 + dp[0]) % modd;
            } else {
                dp[2] = (dp[2] * 2 + dp[1]) % modd;
            }
        }
        return dp[2];
    }
}