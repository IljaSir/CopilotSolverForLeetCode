impl Solution {
    pub fn num_decodings(s: String) -> i32 {
        

        let mut dp = vec![0; s.len() + 1];
        dp[0] = 1;
        for i in 1..=s.len() {
            if s[i-1..i] != "0" {
                dp[i] += dp[i-1];
            }
            if i > 1 && s[i-2..i].parse::<i32>().unwrap() >= 10 && s[i-2..i].parse::<i32>().unwrap() <= 26 {
                dp[i] += dp[i-2];
            }
        }
        dp[s.len()]
    }
}