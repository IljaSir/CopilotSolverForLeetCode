impl Solution {
    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        
        let mut node1 = node1 as usize;
        let mut node2 = node2 as usize;
        let n = edges.len();
        let mut visited1 = vec![false; n];
        let mut visited2 = vec![false; n];
        let mut distance1 = vec![0; n];
        let mut distance2 = vec![0; n];
        let mut stack1 = vec![node1];
        let mut stack2 = vec![node2];
        while !stack1.is_empty() || !stack2.is_empty() {
            if !stack1.is_empty() {
                node1 = stack1.pop().unwrap();
                visited1[node1] = true;
                if edges[node1] != -1 {
                    let next = edges[node1] as usize;
                    if !visited1[next] {
                        distance1[next] = distance1[node1] + 1;
                        stack1.push(next);
                    }
                }
            }
            if !stack2.is_empty() {
                node2 = stack2.pop().unwrap();
                visited2[node2] = true;
                if edges[node2] != -1 {
                    let next = edges[node2] as usize;
                    if !visited2[next] {
                        distance2[next] = distance2[node2] + 1;
                        stack2.push(next);
                    }
                }
            }
        }
        let mut result = -1;
        let mut max_distance = 0;
        for i in 0..n {
            if visited1[i] && visited2[i] {
                let distance = std::cmp::max(distance1[i], distance2[i]);
                if distance < max_distance || result == -1 {
                    result = i as i32;
                    max_distance = distance;
                }
            }
        }
        result
    }
}