impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            dp[i] = 1;
            for j in 0..i {
                if nums[i] >= nums[j] {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
        }
        let mut res = 0;
        for i in 0..nums.len() {
            res = res.max(dp[i]);
        }
        nums.len() as i64 - res
    }
}