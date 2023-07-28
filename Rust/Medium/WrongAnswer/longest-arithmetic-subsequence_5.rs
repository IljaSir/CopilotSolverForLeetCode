impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![2; nums.len()]; nums.len()];
        let mut max = 2;
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                let diff = nums[j] - nums[i];
                for k in 0..i {
                    if nums[k] + diff == nums[i] {
                        dp[i][j] = dp[k][i].max(dp[i][j]);
                    }
                }
                dp[i][j] += 1;
                max = max.max(dp[i][j]);
            }
        }
        max
    }
}