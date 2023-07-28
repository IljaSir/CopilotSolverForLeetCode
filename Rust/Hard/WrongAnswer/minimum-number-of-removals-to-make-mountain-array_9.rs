impl Solution {
    pub fn minimum_mountain_removals(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![1; nums.len()];
        let mut dp2 = vec![1; nums.len()];
        let mut max = 0;
        for i in 1..nums.len() {
            for j in 0..i {
                if nums[i] > nums[j] {
                    dp[i] = dp[i].max(dp[j] + 1);
                }
            }
            max = max.max(dp[i]);
        }
        for i in (0..nums.len() - 1).rev() {
            for j in (i + 1..nums.len()).rev() {
                if nums[i] > nums[j] {
                    dp2[i] = dp2[i].max(dp2[j] + 1);
                }
            }
            max = max.max(dp2[i]);
        }
        (nums.len() - max) as i32
    }
}