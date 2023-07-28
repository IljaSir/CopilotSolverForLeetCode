impl Solution {
    pub fn valid_path(n: i32, edges: Vec<Vec<i32>>, source: i32, destination: i32) -> bool {
        
        let mut graph = vec![vec![]; n as usize];
        for edge in edges {
            graph[edge[0] as usize].push(edge[1]);
            graph[edge[1] as usize].push(edge[0]);
        }
        let mut visited = vec![false; n as usize];
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(source);
        while !queue.is_empty() {
            let u = queue.pop_front().unwrap();
            visited[u as usize] = true;
            if u == destination {
                return true;
            }
            for v in &graph[u as usize] {
                if !visited[*v as usize] {
                    queue.push_back(*v);
                }
            }
        }
        false
    }
}