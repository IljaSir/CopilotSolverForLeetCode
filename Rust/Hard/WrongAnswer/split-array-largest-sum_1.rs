impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let n = nums.len();
        let mut sums = vec![0; n + 1];
        for i in 0..n {
            sums[i + 1] = sums[i] + nums[i];
        }
        let mut dp = vec![vec![0; k + 1]; n + 1];
        for i in 0..=n {
            dp[i][0] = sums[n] - sums[i];
        }
        for i in (0..n).rev() {
            for j in 1..=k {
                dp[i][j] = std::i32::MAX;
                for p in i + 1..=n {
                    dp[i][j] = std::cmp::min(dp[i][j], std::cmp::max(dp[p][j - 1], sums[p] - sums[i]));
                }
            }
        }
        dp[0][k]
    }
}