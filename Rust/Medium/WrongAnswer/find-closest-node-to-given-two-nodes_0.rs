impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut graph = vec![vec![]; edges.len()];
        for i in 0..edges.len() {
            if edges[i] != -1 {
                graph[i].push(edges[i] as usize);
            }
        }
        let mut visited = vec![false; edges.len()];
        let mut queue = Vec::new();
        let mut node1_path = vec![false; edges.len()];
        let mut node2_path = vec![false; edges.len()];
        queue.push(node1 as usize);
        while !queue.is_empty() {
            let node = queue.remove(0);
            if node == node2 as usize {
                return node2;
            }
            visited[node] = true;
            node1_path[node] = true;
            for &child in graph[node].iter() {
                if !visited[child] {
                    queue.push(child);
                }
            }
        }
        visited = vec![false; edges.len()];
        queue.push(node2 as usize);
        while !queue.is_empty() {
            let node = queue.remove(0);
            if node1_path[node] {
                return node as i32;
            }
            visited[node] = true;
            node2_path[node] = true;
            for &child in graph[node].iter() {
                if !visited[child] {
                    queue.push(child);
                }
            }
        }
        -1
    }
}