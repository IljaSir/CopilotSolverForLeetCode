impl Solution {
    pub fn eventual_safe_nodes(graph: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut visited = vec![0; graph.len()];
        for i in 0..graph.len() {
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
        visited[i] = -1;
        for &j in &graph[i] {
            if !Self::dfs(j as usize, graph, visited) {
                return false;
            }
        }
        visited[i] = 1;
        true
    }
}