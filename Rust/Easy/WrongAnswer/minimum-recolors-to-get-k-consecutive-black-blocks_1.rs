impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let n = blocks.len();
        let mut dp = vec![vec![std::i32::MAX; n + 1]; n + 1];
        for i in 0..=n {
            dp[i][0] = 0;
        }
        for i in 0..n {
            let mut cnt = 0;
            for j in i..n {
                cnt += if blocks.chars().nth(j).unwrap() == 'W' { 1 } else { 0 };
                for p in 0..=j - i + 1 {
                    let q = j - i + 1 - p;
                    dp[j + 1][p] = dp[j + 1][p].min(dp[i][q] + cnt);
                }
            }
        }
        dp[n][k as usize]
    }
}