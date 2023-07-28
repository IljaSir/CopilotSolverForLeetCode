impl Solution {
    pub fn length_of_lis(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![1; nums.len()];
        let mut max = 1;
        for i in 1..nums.len() {
            for j in 0..i {
                if nums[i] - nums[j] <= k {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            max = max.max(dp[i]);
        }
        max
    }
}