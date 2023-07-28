impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut res = 0;
        let mut dp = vec![0; 201];
        for i in 0..nums.len() {
            for k in 0..i {
                if nums[i] - nums[k] == diff {
                    dp[nums[i] as usize] += dp[nums[k] as usize] + 1;
                }
            }
            res += dp[nums[i] as usize];
        }
        res
    }
}