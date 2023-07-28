impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let n = graph.len();
        let mut res = vec![];
        let mut path = vec![];
        Solution::dfs(&graph, &mut res, &mut path, 0, n as i32 - 1);
        res
    }
    
    fn dfs(graph: &Vec<Vec<i32>>, res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, cur: i32, target: i32) {
        path.push(cur);
        if cur == target {
            res.push(path.clone());
        } else {
            for &next in graph[cur as usize].iter() {
                Solution::dfs(graph, res, path, next, target);
            }
        }
        path.pop();
    }
}