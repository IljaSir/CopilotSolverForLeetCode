impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![2; n]; n];
        let mut res = 2;
        for i in 0..n {
            for j in i+1..n {
                let d = nums[j] - nums[i];
                for k in 0..i {
                    if nums[i] - nums[k] == d {
                        dp[i][j] = dp[i][j].max(dp[k][i] + 1);
                    }
                }
                res = res.max(dp[i][j]);
            }
        }
        res
    }
}