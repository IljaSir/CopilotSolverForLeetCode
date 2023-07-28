impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let n = graph.len();
        let mut vis = vec![false; n];
        let mut ans = vec![];
        let mut path = vec![];
        Self::dfs(0, n - 1, &graph, &mut vis, &mut path, &mut ans);
        ans
    }
    fn dfs(src: usize, dest: usize, graph: &Vec<Vec<i32>>, vis: &mut Vec<bool>, path: &mut Vec<i32>, ans: &mut Vec<Vec<i32>>) {
        vis[src] = true;
        path.push(src as i32);
        if src == dest {
            ans.push(path.clone());
        } else {
            for &v in graph[src].iter() {
                if !vis[v as usize] {
                    Self::dfs(v as usize, dest, graph, vis, path, ans);
                }
            }
        }
        path.pop();
        vis[src] = false;
    }
}