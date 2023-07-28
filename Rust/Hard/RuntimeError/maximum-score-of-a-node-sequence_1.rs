impl Solution {
    pub fn maximum_score(scores: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let n = scores.len();
        let mut g = vec![vec![]; n];
        for e in edges {
            g[e[0] as usize].push(e[1] as usize);
            g[e[1] as usize].push(e[0] as usize);
        }
        let mut dp = vec![vec![-1; n]; n];
        Self::dfs(0, n, &mut dp, &scores, &g)
    }
    fn dfs(u: usize, f: usize, dp: &mut Vec<Vec<i32>>, scores: &Vec<i32>, g: &Vec<Vec<usize>>) -> i32 {
        let mut res = -1;
        for &v in &g[u] {
            if v == f {
                continue;
            }
            let mut cur = Self::dfs(v, u, dp, scores, g);
            if cur > 0 {
                res = res.max(cur);
            }
        }
        if res == -1 {
            return scores[u];
        }
        for &v in &g[u] {
            if v == f {
                continue;
            }
            for &w in &g[u] {
                if w == f || w == v {
                    continue;
                }
                let cur = dp[v][w];
                if cur > 0 {
                    res = res.max(cur + scores[u]);
                }
            }
        }
        dp[u][f] = res;
        res
    }
}