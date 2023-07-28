impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let mut g = vec![vec![]; n as usize];
        for e in edges {
            let u = e[0] as usize - 1;
            let v = e[1] as usize - 1;
            g[u].push(v);
            g[v].push(u);
        }
        let mut q = std::collections::VecDeque::new();
        let mut vis = vec![false; n as usize];
        let mut t = vec![std::i32::MAX; n as usize];
        q.push_back((0, 0));
        vis[0] = true;
        t[0] = 0;
        while let Some((u, ti)) = q.pop_front() {
            for &v in &g[u] {
                if vis[v] {
                    continue;
                }
                let mut nt = ti + time;
                let mut c = (ti + time) / change;
                if c % 2 == 0 {
                    c += 1;
                }
                nt = std::cmp::max(nt, c * change);
                if t[v] == std::i32::MAX {
                    t[v] = nt;
                    q.push_back((v, nt));
                } else if t[v] > nt {
                    t[v] = nt;
                    q.push_back((v, nt));
                }
            }
        }
        let mut ans = std::i32::MAX;
        for i in 1..n as usize {
            if t[i] != std::i32::MAX {
                ans = std::cmp::min(ans, t[i]);
            }
        }
        ans
    }
}