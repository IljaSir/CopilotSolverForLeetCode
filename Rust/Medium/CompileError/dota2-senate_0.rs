impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        

        let n = n as usize;
        let mut dp = vec![0; n + 1];
        for i in 2..=n {
            dp[i] = i;
            for j in 2..i {
                if i % j == 0 {
                    dp[i] = dp[j] + i / j;
                    break;
                }
            }
        }
        dp[n] as i32
    }
}