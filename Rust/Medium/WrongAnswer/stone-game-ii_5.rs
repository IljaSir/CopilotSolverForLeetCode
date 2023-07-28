impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        
        let mut dp = vec![vec![-1; piles.len()]; piles.len()];
        Self::solve(0, 1, &piles, &mut dp)
    }
    fn solve(i: usize, m: usize, piles: &Vec<i32>, dp: &mut Vec<Vec<i32>>) -> i32 {
        if i >= piles.len() {
            return 0;
        }
        if dp[m][i] != -1 {
            return dp[m][i];
        }
        let mut sum = 0;
        let mut res = 0;
        for x in 1..=2 * m {
            if i + x <= piles.len() {
                sum += piles[i + x - 1];
                res = res.max(sum - Self::solve(i + x, m.max(x), piles, dp));
            }
        }
        dp[m][i] = res;
        res
    }
}