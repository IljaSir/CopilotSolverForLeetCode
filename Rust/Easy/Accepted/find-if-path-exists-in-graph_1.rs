impl Solution {
    pub fn valid_path(n: i32, edges: Vec<Vec<i32>>, source: i32, destination: i32) -> bool {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1]);
            graph[edge[1] as usize].push(edge[0]);
        }
        let mut visited = vec![false; n as usize];
        let mut stack = vec![source];
        while let Some(node) = stack.pop() {
            if node == destination {
                return true;
            }
            visited[node as usize] = true;
            for &neighbor in &graph[node as usize] {
                if !visited[neighbor as usize] {
                    stack.push(neighbor);
                }
            }
        }
        false
    }
}