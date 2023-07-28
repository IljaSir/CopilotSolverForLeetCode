impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut path = vec![];
        Self::dfs(&mut res, &mut path, &graph, 0);
        res
    }

    fn dfs(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, graph: &Vec<Vec<i32>>, node: i32) {
        path.push(node);
        if node == (graph.len() - 1) as i32 {
            res.push(path.clone());
        } else {
            for &next in &graph[node as usize] {
                Self::dfs(res, path, graph, next);
            }
        }
        path.pop();
    }
}