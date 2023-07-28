impl Solution {
    pub fn predict_party_victory(senate: String) -> String {
        

        let mut dp = vec![0; n as usize + 1];
        for i in 2..=n {
            let mut j = i - 1;
            while j > 0 {
                if i % j == 0 {
                    dp[i as usize] = dp[j as usize] + i / j;
                    break;
                }
                j -= 1;
            }
        }
        dp[n as usize]
    }
}