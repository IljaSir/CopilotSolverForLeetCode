impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![Vec::new(); n];
        for edge in edges {
            let u = edge[0] as usize;
            let v = edge[1] as usize;
            graph[u].push(v);
            graph[v].push(u);
        }
        let mut visited = vec![false; n];
        Self::dfs(0, &mut visited, &graph, &has_apple) * 2
    }
    
    fn dfs(u: usize, visited: &mut Vec<bool>, graph: &Vec<Vec<usize>>, has_apple: &Vec<bool>) -> i32 {
        visited[u] = true;
        let mut res = 0;
        for &v in &graph[u] {
            if visited[v] {
                continue;
            }
            let tmp = Self::dfs(v, visited, graph, has_apple);
            if tmp == 0 && !has_apple[v] {
                continue;
            }
            res += tmp + 1;
        }
        res
    }
}