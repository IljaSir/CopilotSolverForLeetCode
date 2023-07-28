impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![0; n]; n];
        let mut ans = 2;
        for i in 0..n {
            for j in i+1..n {
                dp[i][j] = 2;
                for k in 0..i {
                    if nums[i] - nums[k] == nums[j] - nums[i] {
                        dp[i][j] = dp[i][j].max(dp[k][i] + 1);
                    }
                }
                ans = ans.max(dp[i][j]);
            }
        }
        ans
    }
}