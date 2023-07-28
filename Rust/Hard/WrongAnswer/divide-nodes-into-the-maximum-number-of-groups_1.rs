impl Solution {
    pub fn magnificent_sets(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize - 1].push(edge[1] as usize - 1);
            graph[edge[1] as usize - 1].push(edge[0] as usize - 1);
        }
        let mut dp = vec![0; 1 << n as usize];
        for i in 0..n {
            let mut mask = 1 << i as usize;
            let mut visited = vec![false; n as usize];
            let mut q = std::collections::VecDeque::new();
            q.push_back(i as usize);
            visited[i as usize] = true;
            while let Some(node) = q.pop_front() {
                for &next in &graph[node] {
                    if !visited[next] {
                        visited[next] = true;
                        q.push_back(next);
                        mask |= 1 << next;
                    }
                }
            }
            dp[mask] = 1;
        }
        for i in 0..1 << n as usize {
            for j in 0..1 << n as usize {
                if (i & j) == 0 {
                    dp[i | j] = dp[i | j].max(dp[i] + dp[j]);
                }
            }
        }
        dp[(1 << n as usize) - 1]
    }
}