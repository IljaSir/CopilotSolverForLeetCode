impl Solution {
    pub fn max_sum_div_three(nums: Vec<i32>) -> i32 {
        
        let mut dp = vec![0, 0, 0];
        for n in nums {
            let mut next = dp.clone();
            for i in 0..3 {
                next[(i + n % 3) as usize] = std::cmp::max(next[(i + n % 3) as usize], dp[i] + n);
            }
            dp = next;
        }
        dp[0]
    }
}