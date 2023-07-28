impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        for n in nums.iter() {
            if *n > max {
                max = *n;
            }
        }
        let mut count = vec![0; (max + 1) as usize];
        for n in nums.iter() {
            count[*n as usize] += 1;
        }
        let mut dp = vec![0; (max + 1) as usize];
        dp[1] = count[1];
        for i in 2..(max + 1) as usize {
            dp[i] = std::cmp::max(dp[i - 1], dp[i - 2] + i as i32 * count[i]);
        }
        dp[max as usize]
    }
}