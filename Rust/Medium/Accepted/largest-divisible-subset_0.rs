impl Solution {
    pub fn largest_divisible_subset(nums: Vec<i32>) -> Vec<i32> {
        

        let mut nums = nums;
        nums.sort();
        let mut dp = vec![vec![]; nums.len()];
        for i in 0..nums.len() {
            for j in (0..i).rev() {
                if nums[i] % nums[j] == 0 && dp[j].len() > dp[i].len() {
                    dp[i] = dp[j].clone();
                }
            }
            dp[i].push(nums[i]);
        }
        dp.into_iter().max_by_key(|v| v.len()).unwrap_or_default()
    }
}