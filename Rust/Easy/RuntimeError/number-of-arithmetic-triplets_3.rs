impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut count = 0;
        let mut dp = vec![0; 201];
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                if nums[j] - nums[i] == diff {
                    count += dp[(nums[i] - diff) as usize];
                    dp[nums[j] as usize] += 1;
                }
            }
        }
        count
    }
}