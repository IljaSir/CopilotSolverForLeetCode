impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        let mut max = 0;
        for i in 0..nums.len() {
            let mut j = i;
            while j > 0 && nums[j] > nums[j - 1] {
                j -= 1;
            }
            dp[i] = if j > 0 { dp[j - 1] + i - j } else { i - j };
            max = max.max(dp[i]);
        }
        nums.len() as i64 - max as i64
    }
}