impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 10_001];
        for num in nums {
            count[num as usize] += num;
        }
        let mut dp = vec![0; 10_001];
        dp[1] = count[1];
        for i in 2..10_001 {
            dp[i] = std::cmp::max(dp[i - 1], dp[i - 2] + count[i]);
        }
        dp[10_000]
    }
}