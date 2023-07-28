impl Solution {
    pub fn longest_arith_seq_length(nums: Vec<i32>) -> i32 {
        
        let len = nums.len();
        let mut dp = vec![vec![0; len]; len];
        let mut res = 0;
        for i in 0..len {
            for j in 0..i {
                let d = nums[i] - nums[j];
                let mut max = 0;
                for k in 0..j {
                    if nums[j] - nums[k] == d {
                        max = max.max(dp[k][j]);
                    }
                }
                dp[j][i] = max + 1;
                res = res.max(dp[j][i]);
            }
        }
        res + 1
    }
}