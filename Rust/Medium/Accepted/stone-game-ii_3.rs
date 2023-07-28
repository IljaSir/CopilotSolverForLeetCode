impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![-1; 101]; 101];
        let mut sum = vec![0; 101];
        for i in (0..piles.len()).rev() {
            sum[i] = sum[i + 1] + piles[i];
        }
        Self::dfs(&piles, &mut dp, &sum, 0, 1)
    }
    fn dfs(piles: &Vec<i32>, dp: &mut Vec<Vec<i32>>, sum: &Vec<i32>, i: usize, m: usize) -> i32 {
        if i == piles.len() {
            return 0;
        }
        if dp[i][m] != -1 {
            return dp[i][m];
        }
        let mut res = 0;
        for x in 1..=2 * m {
            if i + x > piles.len() {
                break;
            }
            res = res.max(sum[i] - Self::dfs(piles, dp, sum, i + x, x.max(m)));
        }
        dp[i][m] = res;
        res
    }
}