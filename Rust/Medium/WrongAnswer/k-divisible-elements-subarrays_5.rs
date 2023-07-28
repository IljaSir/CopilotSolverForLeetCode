impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut dp = vec![0; nums.len() + 1];
        let mut sum = 0;
        let mut ret = 0;
        for i in 0..nums.len() {
            sum = (sum + nums[i]) % p;
            dp[i + 1] = dp[i] + (sum == 0) as i32;
            if i as i32 >= k {
                sum = (sum - nums[i - k as usize]) % p;
                dp[i + 1] -= dp[i - k as usize + 1];
            }
            ret += dp[i + 1];
        }
        ret
    }
}