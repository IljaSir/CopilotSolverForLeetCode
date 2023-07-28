impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut g: Vec<Vec<(usize, i32)>> = vec![vec![]; n];
        for r in roads {
            g[r[0] as usize].push((r[1] as usize, r[2]));
            g[r[1] as usize].push((r[0] as usize, r[2]));
        }
        let mut dist = vec![std::i32::MAX; n];
        let mut cnt = vec![0; n];
        cnt[0] = 1;
        dist[0] = 0;
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((d, u))) = heap.pop() {
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &g[u] {
                if d + w < dist[v] {
                    dist[v] = d + w;
                    cnt[v] = cnt[u];
                    heap.push(std::cmp::Reverse((dist[v], v)));
                } else if d + w == dist[v] {
                    cnt[v] = (cnt[v] + cnt[u]) % 1_000_000_007;
                }
            }
        }
        cnt[n - 1]
    }
}