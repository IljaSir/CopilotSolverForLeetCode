impl Solution {
    pub fn valid_path(n: i32, edges: Vec<Vec<i32>>, source: i32, destination: i32) -> bool {
        
        let mut graph = vec![vec![]; n as usize];
        for e in edges {
            graph[e[0] as usize].push(e[1] as usize);
            graph[e[1] as usize].push(e[0] as usize);
        }
        let mut visited = vec![false; n as usize];
        let mut q = std::collections::VecDeque::new();
        q.push_back(source as usize);
        while !q.is_empty() {
            let curr = q.pop_front().unwrap();
            if curr == destination as usize {
                return true;
            }
            visited[curr] = true;
            for &next in &graph[curr] {
                if !visited[next] {
                    q.push_back(next);
                }
            }
        }
        false
    }
}