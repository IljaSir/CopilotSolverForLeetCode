impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for e in edges {
            let u = e[0] as usize - 1;
            let v = e[1] as usize - 1;
            g[u].push(v);
            g[v].push(u);
        }
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, 0));
        let mut seen = vec![false; n];
        let mut ans = 1 << 30;
        while let Some((u, t)) = q.pop_front() {
            let u = u as usize;
            if u == n - 1 {
                ans = ans.min(t);
                continue;
            }
            if seen[u] {
                continue;
            }
            seen[u] = true;
            for &v in &g[u] {
                let v = v as usize;
                let t = t + time;
                let t = t + (change - t % change) % change;
                q.push_back((v, t));
            }
        }
        ans
    }
}