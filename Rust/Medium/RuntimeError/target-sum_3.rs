impl Solution {
    pub fn find_target_sum_ways(nums: Vec<i32>, target: i32) -> i32 {
        

        let sum: i32 = nums.iter().sum();
        if (target + sum) % 2 == 1 || target > sum {
            return 0;
        }
        let target = (target + sum) / 2;
        let mut dp = vec![0; (target + 1) as usize];
        dp[0] = 1;
        for num in nums {
            for i in (num..=target).rev() {
                dp[i as usize] += dp[(i - num) as usize];
            }
        }
        dp[target as usize]
    }
}