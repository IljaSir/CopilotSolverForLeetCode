impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![vec![2; n]; n];
        let mut res = 2;
        for i in 1..n {
            for j in 0..i {
                let d = nums[i] - nums[j];
                let mut max_len = 0;
                for k in 0..j {
                    if nums[j] - nums[k] == d {
                        max_len = max_len.max(dp[k][j]);
                    }
                }
                dp[j][i] = max_len + 1;
                res = res.max(dp[j][i]);
            }
        }
        res
    }
}