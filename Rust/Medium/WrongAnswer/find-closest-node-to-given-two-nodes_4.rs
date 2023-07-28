impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut node1 = node1 as usize;
        let mut node2 = node2 as usize;
        let mut visited = vec![false; edges.len()];
        while node1 != node2 {
            if visited[node1] || visited[node2] {
                return -1;
            }
            visited[node1] = true;
            visited[node2] = true;
            if node1 != node2 {
                node1 = if edges[node1] == -1 { node1 } else { edges[node1] as usize };
            }
            if node1 != node2 {
                node2 = if edges[node2] == -1 { node2 } else { edges[node2] as usize };
            }
        }
        node1 as i32
    }
}