impl Solution {
    pub fn champagne_tower(poured: i32, query_row: i32, query_glass: i32) -> f64 {
        
        let mut dp = vec![vec![0.0; 101]; 101];
        dp[0][0] = poured as f64;
        for i in 0..query_row {
            for j in 0..=i {
                if dp[i as usize][j as usize] > 1.0 {
                    let left = (dp[i as usize][j as usize] - 1.0) / 2.0;
                    dp[i as usize + 1][j as usize] += left;
                    dp[i as usize + 1][j as usize + 1] += left;
                }
            }
        }
        if dp[query_row as usize][query_glass as usize] > 1.0 {
            1.0
        } else {
            dp[query_row as usize][query_glass as usize]
        }
    }
}