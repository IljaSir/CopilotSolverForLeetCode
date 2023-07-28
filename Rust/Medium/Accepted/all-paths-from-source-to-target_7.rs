impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut path = vec![];
        path.push(0);
        Solution::dfs(&graph, &mut res, &mut path, 0);
        res
    }
    pub fn dfs(graph: &Vec<Vec<i32>>, res: &mut Vec<Vec<i32>>, path: &mut Vec<i32>, index: i32) {
        if index == (graph.len() - 1) as i32 {
            res.push(path.clone());
            return;
        }
        for &i in graph[index as usize].iter() {
            path.push(i);
            Solution::dfs(graph, res, path, i);
            path.pop();
        }
    }
}