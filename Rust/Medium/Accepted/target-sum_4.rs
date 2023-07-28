impl Solution {
    pub fn find_target_sum_ways(nums: Vec<i32>, target: i32) -> i32 {
        

        let sum:i32 = nums.iter().sum();
        if (sum as i32 - target as i32) % 2 != 0 || sum < target {
            return 0;
        }
        let target = (sum as i32 - target as i32) / 2;
        let mut dp = vec![0; (target + 1) as usize];
        dp[0] = 1;
        for num in nums {
            for i in (num as usize..=target as usize).rev() {
                dp[i] += dp[i - num as usize];
            }
        }
        dp[target as usize]
    }
}