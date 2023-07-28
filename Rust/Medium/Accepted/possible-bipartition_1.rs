impl Solution {
    pub fn possible_bipartition(n: i32, dislikes: Vec<Vec<i32>>) -> bool {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for d in dislikes {
            g[(d[0] - 1) as usize].push((d[1] - 1) as usize);
            g[(d[1] - 1) as usize].push((d[0] - 1) as usize);
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
                for &v in &g[u] {
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