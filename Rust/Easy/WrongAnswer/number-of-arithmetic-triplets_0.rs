impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            for j in 0..i {
                if nums[i] - nums[j] == diff {
                    dp[i] += dp[j] + 1;
                    res += dp[j];
                }
            }
        }
        res
    }
}