impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let n = blocks.len();
        let k = k as usize;
        let mut dp = vec![vec![0; n], vec![0; n]];
        let mut b = 0;
        for i in 0..n {
            if blocks.as_bytes()[i] == 'B' as u8 {
                b += 1;
            }
            dp[0][i] = b;
        }
        for i in 1..k {
            let mut b = 0;
            let mut min = std::i32::MAX;
            for j in 0..n {
                if blocks.as_bytes()[j] == 'B' as u8 {
                    b += 1;
                }
                if j >= i {
                    if blocks.as_bytes()[j - i] == 'B' as u8 {
                        b -= 1;
                    }
                    min = min.min(dp[(i - 1) % 2][j - i] + (i + 1 - b));
                }
                dp[i % 2][j] = min;
            }
        }
        dp[(k - 1) % 2][n - 1]
    }
}