impl Solution {
    pub fn is_possible(n: i32, edges: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut adj = vec![vec![]; n + 1];
        for edge in edges {
            adj[edge[0] as usize].push(edge[1] as usize);
            adj[edge[1] as usize].push(edge[0] as usize);
        }
        let mut degree = vec![0; n + 1];
        for i in 1..=n {
            degree[i] = adj[i].len();
        }
        let mut odd = 0;
        for i in 1..=n {
            if degree[i] % 2 == 1 {
                odd += 1;
            }
        }
        if odd == 0 {
            return true;
        }
        if odd % 2 == 1 {
            return false;
        }
        let mut visited = vec![false; n + 1];
        for i in 1..=n {
            if degree[i] % 2 == 1 {
                if !visited[i] {
                    if !dfs(i, &mut visited, &adj, &mut degree) {
                        return false;
                    }
                }
            }
        }
        true
    }
}