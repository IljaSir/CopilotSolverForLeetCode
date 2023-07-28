impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut path = vec![];
        let n = graph.len();
        path.push(0);
        Self::dfs(&graph, 0, n - 1, &mut path, &mut res);
        res
    }
    fn dfs(graph: &Vec<Vec<i32>>, cur: usize, n: usize, path: &mut Vec<i32>, res: &mut Vec<Vec<i32>>) {
        if cur == n {
            res.push(path.clone());
            return;
        }
        for &v in graph[cur].iter() {
            path.push(v);
            Self::dfs(graph, v as usize, n, path, res);
            path.pop();
        }
    }
}