impl Solution {
    pub fn k_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut nums = nums;
        nums.sort();
        let mut sums = vec![0; nums.len()];
        sums[0] = nums[0];
        for i in 1..nums.len() {
            sums[i] = sums[i - 1] + nums[i];
        }
        let mut dp = vec![vec![0; nums.len()]; k as usize];
        for i in 0..nums.len() {
            dp[0][i] = sums[i];
        }
        for i in 1..k as usize {
            for j in 0..nums.len() {
                if j < i {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + nums[j];
                }
            }
        }
        dp[k as usize - 1][nums.len() - 1] as i64
    }
}