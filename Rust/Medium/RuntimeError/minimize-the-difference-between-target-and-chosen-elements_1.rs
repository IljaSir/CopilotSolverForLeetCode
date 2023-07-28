impl Solution {
    pub fn minimize_the_difference(mat: Vec<Vec<i32>>, target: i32) -> i32 {
        
        let mut dp = vec![vec![false; 800]; 70];
        for i in 0..70 {
            for j in 0..800 {
                dp[i][j] = false;
            }
        }
        dp[0][mat[0][0] as usize] = true;
        for i in 1..mat[0].len() {
            dp[0][mat[0][i] as usize] = true;
        }
        for i in 1..mat.len() {
            for j in 0..800 {
                if dp[i - 1][j] {
                    for k in 0..mat[i].len() {
                        dp[i][j + mat[i][k] as usize] = true;
                    }
                }
            }
        }
        let mut ans = std::i32::MAX;
        for i in 0..800 {
            if dp[mat.len() - 1][i] {
                ans = ans.min((i as i32 - target).abs());
            }
        }
        ans
    }
}