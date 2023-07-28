impl Solution {
    pub fn stone_game_ii(piles: Vec<i32>) -> i32 {
        
        let n = piles.len();
        let mut pre_sum = vec![0; n + 1];
        for i in 0..n {
            pre_sum[i + 1] = pre_sum[i] + piles[i];
        }
        let mut dp = vec![vec![-1; n]; n];
        Self::dfs(&mut dp, 0, 1, &pre_sum)
    }
    fn dfs(dp: &mut Vec<Vec<i32>>, i: usize, m: usize, pre_sum: &[i32]) -> i32 {
        let n = pre_sum.len() - 1;
        if i == n {
            return 0;
        }
        if dp[i][m] != -1 {
            return dp[i][m];
        }
        let mut res = 0;
        for x in 1..=2 * m {
            if i + x > n {
                break;
            }
            let sum = pre_sum[n] - pre_sum[i];
            let tmp = sum - Self::dfs(dp, i + x, m.max(x), pre_sum);
            res = res.max(tmp);
        }
        dp[i][m] = res;
        res
    }
}