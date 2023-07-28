impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for e in edges {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut visited = vec![false; n as usize];
        Self::dfs(0, &mut visited, &mut graph, &has_apple) * 2
    }
    fn dfs(u: usize, visited: &mut Vec<bool>, graph: &mut Vec<Vec<usize>>, has_apple: &Vec<bool>) -> i32 {
        visited[u] = true;
        let mut ans = 0;
        for &v in graph[u].iter() {
            if !visited[v] {
                ans += Self::dfs(v, visited, graph, has_apple);
            }
        }
        if ans > 0 || has_apple[u] {
            ans += 1;
        }
        ans
    }
}