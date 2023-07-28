impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut visited = vec![false; edges.len()];
        let mut nodes = vec![(node1, 0), (node2, 0)];
        let mut min = std::i32::MAX;
        let mut min_node = -1;
        while !nodes.is_empty() {
            let (node, dist) = nodes.pop().unwrap();
            if visited[node as usize] {
                continue;
            }
            visited[node as usize] = true;
            if edges[node as usize] == -1 {
                continue;
            }
            if dist > min {
                continue;
            }
            let neighbor = edges[node as usize];
            if visited[neighbor as usize] {
                if dist < min {
                    min = dist;
                    min_node = node;
                }
            } else {
                nodes.push((neighbor, dist + 1));
            }
        }
        min_node
    }
}