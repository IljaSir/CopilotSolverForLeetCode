impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            let (from, to) = (edge[0] as usize, edge[1] as usize);
            graph[to].push(from);
        }
        let mut result = vec![vec![]; n as usize];
        for i in 0..n as usize {
            Self::dfs(&graph, i, &mut result);
        }
        result
    }
    fn dfs(graph: &[Vec<usize>], node: usize, result: &mut Vec<Vec<i32>>) {
        for &parent in &graph[node] {
            result[node].push(parent as i32);
            Self::dfs(graph, parent, result);
        }
        result[node].sort();
    }
}