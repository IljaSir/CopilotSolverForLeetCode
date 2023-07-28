impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![2; n]; n];
        let mut max = 2;
        for i in 1..n {
            for j in 0..i {
                let d = nums[i] - nums[j];
                for k in 0..j {
                    if nums[j] - nums[k] == d {
                        dp[j][i] = dp[j][i].max(dp[k][j] + 1);
                        max = max.max(dp[j][i]);
                    }
                }
            }
        }
        max
    }
}