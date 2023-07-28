impl Solution {
    pub fn get_max_len(nums: Vec<i32>) -> i32 {
        
        let mut n = nums.len();
        let mut dp = vec![(0, 0); n];
        if nums[0] < 0 {
            dp[0] = (1, 0);
        } else if nums[0] > 0 {
            dp[0] = (0, 1);
        }
        let mut ans = dp[0].1;
        for i in 1..n {
            if nums[i] < 0 {
                dp[i] = (dp[i - 1].1 + 1, dp[i - 1].0);
            } else if nums[i] > 0 {
                dp[i] = (dp[i - 1].0, dp[i - 1].1 + 1);
            }
            ans = ans.max(dp[i].1);
        }
        ans as i32
    }
}