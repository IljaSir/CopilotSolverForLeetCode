impl Solution {
    pub fn can_partition(nums: Vec<i32>) -> bool {
        

        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i];
        }
        if sum % 2 != 0 {
            return false;
        }
        let sum = sum / 2;
        let mut dp = vec![vec![false; sum as usize + 1]; n + 1];
        for i in 0..=n {
            dp[i][0] = true;
        }
        for i in 1..=n {
            for j in 1..=sum as usize {
                if j >= nums[i - 1] as usize {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1] as usize];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        dp[n][sum as usize]
    }
}