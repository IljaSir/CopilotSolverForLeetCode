impl Solution {
    pub fn collect_the_coins(coins: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let n = coins.len();
        let mut graph = vec![vec![]; n];
        for e in edges {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut dp = vec![vec![0; 3]; n];
        Self::dfs(0, 0, &coins, &graph, &mut dp);
        dp[0][0]
    }
    fn dfs(u: usize, f: usize, coins: &Vec<i32>, graph: &Vec<Vec<usize>>, dp: &mut Vec<Vec<i32>>) {
        dp[u][0] = coins[u];
        for &v in &graph[u] {
            if v == f { continue; }
            Self::dfs(v, u, coins, graph, dp);
            dp[u][2] += dp[v][0].max(dp[v][1]).max(dp[v][2]);
        }
        dp[u][1] = dp[u][0] + dp[u][2];
        for &v in &graph[u] {
            if v == f { continue; }
            dp[u][1] = dp[u][1].max(dp[u][0] + dp[v][1] + dp[u][2] - dp[v][0].max(dp[v][1]).max(dp[v][2]));
        }
    }
}