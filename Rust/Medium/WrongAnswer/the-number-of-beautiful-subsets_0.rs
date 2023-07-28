impl Solution {
    pub fn beautiful_subsets(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let n = nums.len();
        let mut dp = vec![0; 1 << n];
        dp[0] = 1;
        for i in 0..n {
            for j in 0..i {
                if nums[i] - nums[j] < k {
                    dp[1 << i] += dp[1 << j];
                }
            }
            for j in 1..(1 << i) {
                if (j & (1 << i)) != 0 {
                    dp[j | (1 << i)] = dp[j];
                }
            }
        }
        dp.iter().sum()
    }
}