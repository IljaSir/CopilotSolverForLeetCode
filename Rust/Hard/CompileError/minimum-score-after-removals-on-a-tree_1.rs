impl Solution {
    pub fn minimum_score(nums: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let mut res = i32::MAX;
        let n = nums.len();
        let mut g = vec![vec![]; n];
        for e in &edges {
            let u = e[0] as usize;
            let v = e[1] as usize;
            g[u].push(v);
            g[v].push(u);
        }
        let mut dp = vec![0; n];
        let mut sz = vec![0; n];
        let mut vis = vec![false; n];
        let mut dfs = |u, fa| {
            sz[u] = 1;
            for &v in &g[u] {
                if v == fa || vis[v] {
                    continue;
                }
                dfs(v, u);
                sz[u] += sz[v];
                dp[u] ^= dp[v];
            }
            dp[u] ^= nums[u];
        };
        let mut dfs2 = |u, fa, sum| {
            res = res.min((sum ^ dp[u]) - dp[u]);
            for &v in &g[u] {
                if v == fa || vis[v] {
                    continue;
                }
                dfs2(v, u, sum ^ dp[v] ^ dp[u]);
            }
        };
        let mut solve = |u| {
            dfs(u, n);
            dfs2(u, n, 0);
        };
        let mut dfs3 = |u, fa| {
            vis[u] = true;
            for &v in &g[u] {
                if v == fa || vis[v] {
                    continue;
                }
                if sz[v] < sz[u] {
                    solve(v);
                } else {
                    solve(u);
                }
                dfs3(v, u);
                break;
            }
        };
        dfs3(0, n);
        res
    }
}