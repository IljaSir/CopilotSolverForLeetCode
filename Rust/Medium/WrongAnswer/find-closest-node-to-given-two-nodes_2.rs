impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut node1 = node1;
        let mut node2 = node2;
        let mut visited1 = vec![false; edges.len()];
        let mut visited2 = vec![false; edges.len()];
        while node1 != -1 || node2 != -1 {
            if node1 != -1 {
                if visited1[node1 as usize] {
                    return node1;
                }
                visited1[node1 as usize] = true;
                node1 = edges[node1 as usize];
            }
            if node2 != -1 {
                if visited2[node2 as usize] {
                    return node2;
                }
                visited2[node2 as usize] = true;
                node2 = edges[node2 as usize];
            }
        }
        -1
    }
}