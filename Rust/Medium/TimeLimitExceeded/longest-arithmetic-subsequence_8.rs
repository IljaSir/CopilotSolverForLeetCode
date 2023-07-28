impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![2; nums.len()]; nums.len()];
        let mut max = 2;
        for i in 1..nums.len() {
            for j in 0..i {
                dp[j][i] = 2;
                for k in 0..j {
                    if nums[j] - nums[k] == nums[i] - nums[j] {
                        dp[j][i] = std::cmp::max(dp[j][i], dp[k][j] + 1);
                    }
                }
                max = std::cmp::max(max, dp[j][i]);
            }
        }
        max
    }
}