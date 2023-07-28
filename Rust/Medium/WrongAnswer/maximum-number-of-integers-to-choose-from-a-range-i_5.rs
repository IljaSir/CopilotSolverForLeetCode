impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let banned: Vec<i32> = banned.into_iter().filter(|&x| x <= n).collect();
        let mut dp = vec![0; (max_sum + 1) as usize];
        dp[0] = 1;
        for i in 1..=n {
            if banned.contains(&i) {
                continue;
            }
            for j in (i..=max_sum).rev() {
                dp[j as usize] += dp[(j - i) as usize];
                dp[j as usize] %= 1000000007;
            }
        }
        dp[max_sum as usize]
    }
}