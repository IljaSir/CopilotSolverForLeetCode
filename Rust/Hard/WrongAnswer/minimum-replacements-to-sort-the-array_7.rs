impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        let mut res = 0;
        for i in 1..nums.len() {
            let mut k = 0;
            while i > k && nums[i] > nums[i - k - 1] {
                k += 1;
            }
            dp[i] = k;
            if k > 0 {
                dp[i] += dp[i - k];
            }
            res = res.max(dp[i] as i64);
        }
        res
    }
}