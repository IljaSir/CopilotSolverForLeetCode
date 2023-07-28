impl Solution {
    pub fn max_coins(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut nums = nums;
        nums.insert(0, 1);
        nums.push(1);
        let mut dp = vec![vec![0; n+2]; n+2];
        for i in (0..n).rev() {
            for j in i+1..n+1 {
                for k in i+1..j+1 {
                    dp[i][j] = std::cmp::max(dp[i][j], nums[i] * nums[k] * nums[j] + dp[i][k-1] + dp[k+1][j]);
                }
            }
        }
        dp[0][n+1]
    }
}