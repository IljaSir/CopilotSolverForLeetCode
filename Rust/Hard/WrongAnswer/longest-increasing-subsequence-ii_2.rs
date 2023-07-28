impl Solution {
    pub fn length_of_lis(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            dp[i] = 1;
            for j in 0..i {
                if (nums[i] - nums[j]).abs() <= k {
                    dp[i] = std::cmp::max(dp[i], dp[j] + 1);
                }
            }
        }
        *dp.iter().max().unwrap()
    }
}