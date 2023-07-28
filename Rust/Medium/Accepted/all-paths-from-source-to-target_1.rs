impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = vec![];
        let mut path: Vec<i32> = vec![];
        path.push(0);
        Self::dfs(&mut res, &mut path, &graph, 0);
        res
    }
    fn dfs(res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, graph: &Vec<Vec<i32>>, node: i32) {
        if node == (graph.len() - 1) as i32 {
            res.push(path.clone());
            return;
        }
        for i in 0..graph[node as usize].len() {
            path.push(graph[node as usize][i]);
            Self::dfs(res, path, graph, graph[node as usize][i]);
            path.pop();
        }
    }
}