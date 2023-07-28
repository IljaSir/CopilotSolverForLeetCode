impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for d in dislikes {
            graph[d[0] as usize - 1].push(d[1] as usize - 1);
            graph[d[1] as usize - 1].push(d[0] as usize - 1);
        }
        let mut color = vec![0; n];
        for i in 0..n {
            if color[i] != 0 {
                continue;
            }
            color[i] = 1;
            let mut q = std::collections::VecDeque::new();
            q.push_back(i);
            while let Some(u) = q.pop_front() {
                for &v in &graph[u] {
                    if color[v] == color[u] {
                        return false;
                    }
                    if color[v] == 0 {
                        color[v] = -color[u];
                        q.push_back(v);
                    }
                }
            }
        }
        true
    }
}