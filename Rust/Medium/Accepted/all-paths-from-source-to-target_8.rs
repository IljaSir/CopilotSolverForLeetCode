impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = Vec::new();
        Solution::dfs(0, &graph, &mut res, &mut Vec::new());
        res
    }
    fn dfs(node: i32, graph: &Vec<Vec<i32>>, res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>) {
        path.push(node);
        if node == (graph.len() - 1) as i32 {
            res.push(path.clone());
        } else {
            for &next in &graph[node as usize] {
                Solution::dfs(next, graph, res, path);
            }
        }
        path.pop();
    }
}