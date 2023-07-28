impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut dp = vec![0; n];
        for i in 1..n {
            for j in 0..i {
                if nums[j] < nums[i] {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
        }
        let mut dp2 = vec![0; n];
        for i in (0..n-1).rev() {
            for j in (i+1)..n {
                if nums[j] < nums[i] {
                    dp2[i] = dp2[i].max(dp2[j] + 1);
                }
            }
        }
        let mut res = 0;
        for i in 0..n {
            if dp[i] > 0 && dp2[i] > 0 {
                res = res.max(dp[i] + dp2[i] + 1);
            }
        }
        n as i32 - res
    }
}