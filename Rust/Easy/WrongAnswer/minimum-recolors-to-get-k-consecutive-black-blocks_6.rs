impl Solution {
    pub fn minimum_recolors(blocks: String, k: i32) -> i32 {
        
        let mut dp = vec![vec![0; blocks.len()]; blocks.len()];
        let mut sum = vec![0; blocks.len()];
        let mut count = 0;
        let mut res = i32::max_value();
        for (i, c) in blocks.chars().enumerate() {
            count += if c == 'B' { 1 } else { 0 };
            sum[i] = count;
            dp[i][i] = if c == 'W' { 1 } else { 0 };
        }
        for l in 2..=blocks.len() {
            for i in 0..=blocks.len() - l {
                let j = i + l - 1;
                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                if j - i + 1 >= k as usize {
                    let mut temp = dp[i][j];
                    if i > 0 {
                        temp += sum[i - 1];
                    }
                    if j + 1 < blocks.len() {
                        temp += sum[blocks.len() - 1] - sum[j];
                    }
                    res = res.min(temp);
                }
            }
        }
        res
    }
}