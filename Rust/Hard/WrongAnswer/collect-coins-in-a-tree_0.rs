impl Solution {
    pub fn collect_the_coins(coins: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let n = coins.len();
        let mut g = vec![vec![]; n];
        for e in edges {
            g[e[0] as usize].push(e[1] as usize);
            g[e[1] as usize].push(e[0] as usize);
        }
        let mut dp = vec![vec![0; 3]; n];
        let mut visited = vec![false; n];
        Self::dfs(0, &mut dp, &mut visited, &coins, &g);
        dp[0][1]
    }
    fn dfs(u: usize, dp: &mut Vec<Vec<i32>>, visited: &mut Vec<bool>, coins: &Vec<i32>, g: &Vec<Vec<usize>>) {
        visited[u] = true;
        for &v in &g[u] {
            if !visited[v] {
                Self::dfs(v, dp, visited, coins, g);
                dp[u][0] += dp[v][1].min(dp[v][2]);
                dp[u][1] += dp[v][0].min(dp[v][2]);
                dp[u][2] += dp[v][0].min(dp[v][1]);
            }
        }
        dp[u][0] += coins[u];
    }
}