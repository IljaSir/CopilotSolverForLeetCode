impl Solution {
    pub fn eventual_safe_nodes(graph: Vec<Vec<i32>>) -> Vec<i32> {
        
        let n = graph.len();
        let mut visited = vec![0; n];
        let mut res = vec![];
        for i in 0..n {
            if Self::dfs(i, &graph, &mut visited) {
                res.push(i as i32);
            }
        }
        res
    }
    fn dfs(i: usize, graph: &Vec<Vec<i32>>, visited: &mut Vec<i32>) -> bool {
        if visited[i] != 0 {
            return visited[i] == 1;
        }
        visited[i] = 2;
        for &j in &graph[i] {
            if !Self::dfs(j as usize, graph, visited) {
                return false;
            }
        }
        visited[i] = 1;
        true
    }
}