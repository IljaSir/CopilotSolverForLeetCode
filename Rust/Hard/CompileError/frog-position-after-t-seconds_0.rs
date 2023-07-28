impl Solution {
    pub fn frog_position(n: i32, edges: Vec<Vec<i32>>, t: i32, target: i32) -> f64 {
        
        let mut g = vec![vec![]; n as usize];
        for e in edges {
            g[e[0] as usize - 1].push(e[1] as usize - 1);
            g[e[1] as usize - 1].push(e[0] as usize - 1);
        }
        let mut visited = vec![false; n as usize];
        let mut q = Vec::new();
        q.push((0, 1.0));
        visited[0] = true;
        while !q.is_empty() {
            let mut next = Vec::new();
            for (u, p) in q {
                if u == target as usize - 1 {
                    return p;
                }
                let mut deg = 0;
                for &v in &g[u] {
                    if !visited[v] {
                        deg += 1;
                    }
                }
                if deg == 0 {
                    continue;
                }
                let p = p / deg as f64;
                for &v in &g[u] {
                    if !visited[v] {
                        visited[v] = true;
                        next.push((v, p));
                    }
                }
            }
            q = next;
            if q.is_empty() {
                break;
            }
            t -= 1;
            if t == 0 {
                break;
            }
        }
        if t > 0 {
            0.0
        } else {
            1.0
        }
    }
}