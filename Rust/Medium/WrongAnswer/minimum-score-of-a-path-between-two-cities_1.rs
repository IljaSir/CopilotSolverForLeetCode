impl Solution {
    pub fn min_score(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let mut g = vec![vec![]; n as usize];
        for r in roads {
            g[(r[0] - 1) as usize].push((r[1] - 1, r[2]));
            g[(r[1] - 1) as usize].push((r[0] - 1, r[2]));
        }
        let mut q = std::collections::BinaryHeap::new();
        let mut dist = vec![std::i32::MAX; n as usize];
        dist[0] = 0;
        q.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((d, u))) = q.pop() {
            if d > dist[u as usize] {
                continue;
            }
            for &(v, w) in &g[u as usize] {
                if d + w < dist[v as usize] {
                    dist[v as usize] = d + w;
                    q.push(std::cmp::Reverse((d + w, v)));
                }
            }
        }
        dist[(n - 1) as usize]
    }
}