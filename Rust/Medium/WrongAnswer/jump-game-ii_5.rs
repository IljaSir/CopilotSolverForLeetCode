impl Solution {
    pub fn jump(nums: Vec<i32>) -> i32 {
        

        let n = nums.len();
        let mut dp = vec![0; n];
        for i in 0..n {
            let mut j = i + 1;
            while j < n && j <= i + nums[i] as usize {
                dp[j] = dp[i] + 1;
                j += 1;
            }
        }
        dp[n - 1]
    }
}