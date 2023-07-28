impl Solution {
    pub fn number_of_combinations(num: String) -> i32 {
        
        let n = num.len();
        let mut dp = vec![0; n+1];
        dp[0] = 1;
        for i in 1..=n {
            let mut j = i;
            while j > 0 && num[j-1] == '0' {
                j -= 1;
            }
            if j > 0 {
                dp[i] += dp[j-1];
            }
            if i > 1 && j > 0 && num[i-1] == '0' {
                dp[i] += dp[i-1];
            }
            if i > 1 && j > 0 && num[j-1] != '0' {
                let x = num[j-1..i].parse::<i32>().unwrap();
                if x <= 26 {
                    dp[i] += dp[j-1];
                }
            }
            dp[i] %= 1000000007;
        }
        dp[n]
    }
}