impl Solution {
    pub fn delete_and_earn(nums: Vec<i32>) -> i32 {
        
        let mut arr = vec![0; 10001];
        for n in nums {
            arr[n as usize] += n;
        }
        let mut dp = vec![0; 10001];
        dp[1] = arr[1];
        for i in 2..10001 {
            dp[i] = dp[i - 1].max(dp[i - 2] + arr[i]);
        }
        dp[10000]
    }
}