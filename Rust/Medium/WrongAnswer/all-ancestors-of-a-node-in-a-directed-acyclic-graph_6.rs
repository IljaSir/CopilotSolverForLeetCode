impl Solution {
    pub fn get_ancestors(n: i32, edges: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut graph = vec![vec![]; n as usize];
        
        for edge in edges {
            graph[edge[1] as usize].push(edge[0]);
        }
        
        let mut ans = vec![vec![]; n as usize];
        let mut visited = vec![false; n as usize];
        
        for i in 0..n as usize {
            Solution::dfs(i, &graph, &mut ans, &mut visited);
        }
        
        ans
    }
    
    fn dfs(node: usize, graph: &Vec<Vec<i32>>, ans: &mut Vec<Vec<i32>>, visited: &mut Vec<bool>) {
        if visited[node] {
            return;
        }
        
        visited[node] = true;
        
        for &parent in &graph[node] {
            ans[node].push(parent);
            Solution::dfs(parent as usize, graph, ans, visited);
        }
        
        ans[node].sort();
    }
}