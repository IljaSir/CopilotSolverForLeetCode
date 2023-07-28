impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut parent = vec![0; edges.len()];
        let mut visited = vec![false; edges.len()];
        for (i, &e) in edges.iter().enumerate() {
            visited[i] = true;
            if e != -1 {
                parent[e as usize] = i as i32;
            }
        }
        let mut node1_parent = vec![];
        let mut node2_parent = vec![];
        let mut node1 = node1;
        let mut node2 = node2;
        while node1 != -1 {
            node1_parent.push(node1);
            node1 = parent[node1 as usize];
        }
        while node2 != -1 {
            node2_parent.push(node2);
            node2 = parent[node2 as usize];
        }
        node1_parent.reverse();
        node2_parent.reverse();
        let mut i = 0;
        let mut j = 0;
        while i < node1_parent.len() && j < node2_parent.len() && node1_parent[i] == node2_parent[j] {
            i += 1;
            j += 1;
        }
        node1_parent[i-1]
    }
}