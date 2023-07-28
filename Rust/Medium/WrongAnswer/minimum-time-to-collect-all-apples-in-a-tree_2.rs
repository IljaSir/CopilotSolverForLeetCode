impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        
        let mut graph = vec![Vec::new(); n as usize];
        for e in edges {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut visited = vec![false; n as usize];
        Self::dfs(0, &graph, &mut visited, &has_apple) as i32 * 2
    }
    
    fn dfs(node: usize, graph: &Vec<Vec<usize>>, visited: &mut Vec<bool>, has_apple: &Vec<bool>) -> bool {
        visited[node] = true;
        let mut found = false;
        for &n in &graph[node] {
            if visited[n] {
                continue;
            }
            if Self::dfs(n, graph, visited, has_apple) {
                found = true;
            }
        }
        found || has_apple[node]
    }
}