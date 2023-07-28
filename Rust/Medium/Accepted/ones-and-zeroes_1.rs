impl Solution {
    pub fn find_max_form(strs: Vec<String>, m: i32, n: i32) -> i32 {
        

        let mut dp = vec![vec![0; n as usize + 1]; m as usize + 1];
        for s in strs {
            let mut zeros = 0;
            let mut ones = 0;
            for c in s.chars() {
                if c == '0' {
                    zeros += 1;
                } else {
                    ones += 1;
                }
            }
            for i in (zeros..=m as usize).rev() {
                for j in (ones..=n as usize).rev() {
                    dp[i][j] = dp[i][j].max(dp[i - zeros][j - ones] + 1);
                }
            }
        }
        dp[m as usize][n as usize]
    }
}