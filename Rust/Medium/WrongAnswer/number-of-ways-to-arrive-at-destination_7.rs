impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut adj = vec![vec![]; n];
        for r in roads {
            let (a, b, c) = (r[0] as usize, r[1] as usize, r[2]);
            adj[a].push((b, c));
            adj[b].push((a, c));
        }
        let mut dist = vec![std::i64::MAX; n];
        let mut num = vec![0; n];
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((d, u))) = pq.pop() {
            if d > dist[u] {
                continue;
            }
            if d == dist[u] {
                num[u] += 1;
                continue;
            }
            dist[u] = d;
            num[u] = 1;
            for &(v, w) in &adj[u] {
                pq.push(std::cmp::Reverse((d + w as i64, v)));
            }
        }
        num[n - 1] as i32
    }
}