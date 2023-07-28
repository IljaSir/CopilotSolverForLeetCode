impl Solution {
    pub fn count_max_or_subsets(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0; 1 << nums.len()];
        let mut max = 0;
        for i in 0..nums.len() {
            for j in (0..(1 << i)).rev() {
                dp[j | 1 << i] = dp[j] | nums[i];
                max = std::cmp::max(max, dp[j | 1 << i]);
            }
        }
        dp.iter().filter(|&&x| x == max).count() as i32
    }
}