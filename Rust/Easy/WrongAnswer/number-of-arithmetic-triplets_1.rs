impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut dp = vec![0; 201];
        let mut res = 0;
        for i in 0..nums.len() {
            if nums[i] >= diff {
                res += dp[(nums[i] - diff) as usize];
            }
            dp[nums[i] as usize] += 1;
        }
        res
    }
}