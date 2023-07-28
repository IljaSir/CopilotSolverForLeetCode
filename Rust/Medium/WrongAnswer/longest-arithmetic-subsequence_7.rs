impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let len = nums.len();
        let mut dp = vec![vec![0; len]; len];
        let mut ans = 0;
        for i in 0..len {
            for j in 0..i {
                let d = nums[i] - nums[j];
                dp[i][j] = dp[j].iter().enumerate().filter(|(k, _)| *k < j && nums[*k] - nums[j] == d).map(|(_, v)| *v).max().unwrap_or(0) + 1;
                ans = ans.max(dp[i][j]);
            }
        }
        ans
    }
}