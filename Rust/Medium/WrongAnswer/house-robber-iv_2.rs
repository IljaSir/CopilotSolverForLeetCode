impl Solution {
    pub fn min_capability(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let n = nums.len();
        let mut dp = vec![vec![0; n]; k];
        for i in 0..n {
            dp[0][i] = nums[..i+1].iter().max().unwrap().clone();
        }
        for i in 1..k {
            for j in i..n {
                dp[i][j] = dp[i-1][j-1];
                for l in i-1..j {
                    dp[i][j] = dp[i][j].min(dp[i-1][l].max(nums[l+1..j+1].iter().max().unwrap().clone()));
                }
            }
        }
        dp[k-1][n-1]
    }
}