impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut count = vec![0; 10001];
        for &num in &nums {
            count[num as usize] += 1;
        }
        let mut dp = vec![0; 10001];
        dp[1] = count[1];
        for i in 2..10001 {
            dp[i] = std::cmp::max(dp[i - 1], dp[i - 2] + count[i] * i);
        }
        dp[10000]
    }
}