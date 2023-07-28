impl Solution {
    pub fn number_of_good_paths(vals: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        
        let n = vals.len();
        let mut graph = vec![vec![]; n];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1] as usize);
            graph[edge[1] as usize].push(edge[0] as usize);
        }
        let mut ans = 0;
        let mut dp = vec![vec![0; 6]; n];
        let mut visited = vec![false; n];
        Self::dfs(0, &vals, &graph, &mut visited, &mut dp, &mut ans);
        ans
    }
    fn dfs(node: usize, vals: &Vec<i32>, graph: &Vec<Vec<usize>>, visited: &mut Vec<bool>, dp: &mut Vec<Vec<i32>>, ans: &mut i32) {
        visited[node] = true;
        let val = vals[node];
        dp[node][0] = 1;
        for i in 1..6 {
            if val >= i as i32 {
                dp[node][i] = 1;
            }
        }
        for &nxt in &graph[node] {
            if visited[nxt] {
                continue;
            }
            Self::dfs(nxt, vals, graph, visited, dp, ans);
            for i in 0..6 {
                for j in 0..6 {
                    if i + j >= 6 {
                        break;
                    }
                    if i + j > 0 {
                        *ans += dp[node][i] * dp[nxt][j];
                        *ans %= 1000000007;
                    }
                }
            }
            for i in 0..6 {
                if val >= i as i32 {
                    dp[node][i] += dp[nxt][i];
                    dp[node][i] %= 1000000007;
                }
            }
        }