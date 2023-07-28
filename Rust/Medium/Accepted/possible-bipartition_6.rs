impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut graph = vec![Vec::new(); n];
        for edge in dislikes {
            graph[(edge[0] - 1) as usize].push((edge[1] - 1) as usize);
            graph[(edge[1] - 1) as usize].push((edge[0] - 1) as usize);
        }
        let mut color = vec![0; n];
        for i in 0..n {
            if color[i] == 0 {
                let mut queue = Vec::new();
                queue.push(i);
                color[i] = 1;
                while !queue.is_empty() {
                    let node = queue.remove(0);
                    for &next in &graph[node] {
                        if color[next] == color[node] {
                            return false;
                        }
                        if color[next] == 0 {
                            color[next] = -color[node];
                            queue.push(next);
                        }
                    }
                }
            }
        }
        true
    }
}