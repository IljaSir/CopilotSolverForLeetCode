impl Solution {
    pub fn is_bipartite(graph: Vec<Vec<i32>>) -> bool {
        
        let n = graph.len();
        let mut color = vec![0; n];
        let mut stack = vec![];
        for i in 0..n {
            if color[i] == 0 {
                stack.push(i);
                color[i] = 1;
                while let Some(u) = stack.pop() {
                    for &v in &graph[u] {
                        if color[v as usize] == color[u] {
                            return false;
                        }
                        if color[v as usize] == 0 {
                            stack.push(v as usize);
                            color[v as usize] = -color[u];
                        }
                    }
                }
            }
        }
        true
    }
}