impl Solution {
    pub fn k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut dp = vec![vec![0; nums.len() + 1]; k as usize + 1];
        for i in 1..=k as usize {
            for j in 1..=nums.len() {
                dp[i][j] = dp[i][j - 1];
                if i as usize <= j {
                    dp[i][j] = dp[i][j].max(dp[i - 1][j - 1] + nums[j - 1] as i64);
                }
            }
        }
        dp[k as usize][nums.len()] as i64
    }
}