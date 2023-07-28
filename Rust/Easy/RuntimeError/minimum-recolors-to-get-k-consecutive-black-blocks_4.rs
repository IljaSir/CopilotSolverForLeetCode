impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let n = blocks.len();
        let blocks = blocks.as_bytes();
        let mut dp = vec![vec![0; n]; n];
        let mut sum = vec![0; n];
        sum[0] = if blocks[0] == b'W' { 1 } else { 0 };
        for i in 1..n {
            sum[i] = sum[i - 1] + if blocks[i] == b'W' { 1 } else { 0 };
        }
        for i in 0..n {
            dp[i][i] = if blocks[i] == b'W' { 1 } else { 0 };
        }
        for i in 0..n {
            for j in i + 1..n {
                dp[i][j] = dp[i][j - 1] + if blocks[j] == b'W' { 1 } else { 0 };
            }
        }
        let mut f = vec![vec![0; n]; n];
        for i in 0..n {
            f[i][i] = if blocks[i] == b'W' { 1 } else { 0 };
        }
        for i in 0..n {
            for j in i + 1..n {
                f[i][j] = f[i][j - 1];
                if j - k as usize >= i {
                    f[i][j] = f[i][j].min(f[i][j - k as usize]);
                    let t = dp[j - k as usize + 1][j];
                    f[i][j] = f[i][j].min(f[i][j - k as usize] + t);
                }
            }
        }
        f[0][n - 1]
    }
}