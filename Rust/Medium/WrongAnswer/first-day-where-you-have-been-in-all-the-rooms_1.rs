impl Solution {
    pub fn first_day_been_in_all_rooms(next_visit: Vec<i32>) -> i32 {
        
        let n = next_visit.len();
        let mut dp = vec![0; n];
        for i in 1..n {
            dp[i] = (2 * dp[i - 1] + n as i32 - next_visit[i - 1]) % 1000000007;
        }
        dp[n - 1]
    }
}