impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut path = vec![0];
        Self::dfs(0, graph, &mut path, &mut res);
        res
    }
    fn dfs(node: i32, graph: Vec<Vec<i32>>, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if node == graph.len() as i32 - 1 {
            res.push(path.clone());
        } else {
            for &n in &graph[node as usize] {
                path.push(n);
                Self::dfs(n, graph.to_vec(), path, res);
                path.pop();
            }
        }