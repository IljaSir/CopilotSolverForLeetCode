impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut parent = vec![-1; edges.len()];
        let mut max_dist = vec![0; edges.len()];
        let mut queue = Vec::new();
        let mut visited = vec![false; edges.len()];
        queue.push(node1);
        while !queue.is_empty() {
            let node = queue.pop().unwrap();
            if visited[node as usize] {
                continue;
            }
            visited[node as usize] = true;
            if edges[node as usize] != -1 {
                parent[edges[node as usize] as usize] = node;
                max_dist[edges[node as usize] as usize] = max_dist[node as usize].max(1);
                queue.push(edges[node as usize]);
            }
        }
        queue.push(node2);
        while !queue.is_empty() {
            let node = queue.pop().unwrap();
            if visited[node as usize] {
                return node;
            }
            visited[node as usize] = true;
            if edges[node as usize] != -1 {
                parent[edges[node as usize] as usize] = node;
                max_dist[edges[node as usize] as usize] = max_dist[node as usize].max(1);
                queue.push(edges[node as usize]);
            }
        }
        -1
    }
}