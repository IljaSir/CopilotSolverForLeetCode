impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![-1; piles.len()]; piles.len()];
        let mut sum = vec![0; piles.len()];
        sum[piles.len() - 1] = piles[piles.len() - 1];
        for i in (0..piles.len() - 1).rev() {
            sum[i] = sum[i + 1] + piles[i];
        }
        Self::dfs(0, 1, &piles, &sum, &mut dp)
    }
    fn dfs(i: usize, m: usize, piles: &Vec<i32>, sum: &Vec<i32>, dp: &mut Vec<Vec<i32>>) -> i32 {
        if i >= piles.len() {
            return 0;
        }
        if 2 * m >= piles.len() - i {
            return sum[i];
        }
        if dp[i][m] != -1 {
            return dp[i][m];
        }
        let mut res = 0;
        for x in 1..=2 * m {
            res = res.max(sum[i] - Self::dfs(i + x, m.max(x), piles, sum, dp));
        }
        dp[i][m] = res;
        res
    }
}