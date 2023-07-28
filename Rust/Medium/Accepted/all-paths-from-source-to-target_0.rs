impl Solution {
    pub fn all_paths_source_target(graph: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let mut path = Vec::new();
        path.push(0);
        Solution::dfs(&graph, 0, &mut path, &mut result);
        result
    }
    
    fn dfs(graph: &Vec<Vec<i32>>, node: i32, path: &mut Vec<i32>, result: &mut Vec<Vec<i32>>) {
        if node == (graph.len() - 1) as i32 {
            result.push(path.clone());
            return;
        }
        for i in 0..graph[node as usize].len() {
            path.push(graph[node as usize][i]);
            Solution::dfs(graph, graph[node as usize][i], path, result);
            path.pop();
        }
    }
}