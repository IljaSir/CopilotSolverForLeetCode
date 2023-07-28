impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut path = vec![];
        path.push(0);
        Self::dfs(graph, 0, &mut path, &mut ans);
        ans
    }
    fn dfs(graph: Vec<Vec<i32>>, cur: usize, path: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
        if cur == graph.len() - 1 {
            ans.push(path.clone());
            return;
        }
        for &next in &graph[cur] {
            path.push(next);
            Self::dfs(graph, next as usize, path, ans);
            path.pop();
        }
    }
}