impl Solution {
    pub fn is_bipartite(graph: Vec<Vec<i32>>) -> bool {
        
        let mut color = vec![0; graph.len()];
        for i in 0..graph.len() {
            if color[i] == 0 {
                let mut queue = std::collections::VecDeque::new();
                queue.push_back(i);
                color[i] = 1;
                while !queue.is_empty() {
                    let node = queue.pop_front().unwrap();
                    for &n in &graph[node] {
                        if color[n as usize] == color[node] {
                            return false;
                        }
                        if color[n as usize] == 0 {
                            color[n as usize] = -color[node];
                            queue.push_back(n as usize);
                        }
                    }
                }
            }
        }
        true
    }
}