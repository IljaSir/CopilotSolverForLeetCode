impl Solution {
    pub fn get_money_amount(n: i32) -> i32 {
        

        let mut dp = vec![vec![0; n as usize + 1]; n as usize + 1];
        for i in 1..=n {
            dp[i as usize][i as usize] = 0;
        }
        for i in (1..n).rev() {
            for j in (i + 1)..=n {
                let mut min = i32::MAX;
                for k in i..j {
                    let cost = k + i32::max(dp[i as usize][k as usize - 1], dp[k as usize + 1][j as usize]);
                    min = i32::min(min, cost);
                }
                dp[i as usize][j as usize] = min;
            }
        }
        dp[1][n as usize]
    }
}