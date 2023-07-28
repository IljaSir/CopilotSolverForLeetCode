impl Solution {
    pub fn length_of_lis(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        let mut res = 0;
        for i in 0..nums.len() {
            dp[i] = 1;
            for j in 0..i {
                if nums[i] - nums[j] <= k {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            res = res.max(dp[i]);
        }
        res
    }
}