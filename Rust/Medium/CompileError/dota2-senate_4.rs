impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n as usize {
            dp[i] = i as i32;
            for j in (2..i).rev() {
                if i % j == 0 {
                    dp[i] = dp[j] + i as i32 / j as i32;
                    break;
                }
            }
        }
        dp[n as usize]
    }
}