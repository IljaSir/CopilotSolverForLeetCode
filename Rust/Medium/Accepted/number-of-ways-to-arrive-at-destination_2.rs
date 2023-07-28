impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for road in roads {
            let u = road[0] as usize;
            let v = road[1] as usize;
            let w = road[2];
            g[u].push((v, w));
            g[v].push((u, w));
        }
        let mut dist = vec![std::i64::MAX; n];
        let mut ways = vec![0; n];
        dist[0] = 0;
        ways[0] = 1;
        let mut pq = std::collections::BinaryHeap::new();
        pq.push((0, 0));
        while let Some((d, u)) = pq.pop() {
            let d = -d;
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &g[u] {
                let d = d + w as i64;
                if d < dist[v] {
                    dist[v] = d;
                    ways[v] = ways[u];
                    pq.push((-d, v));
                } else if d == dist[v] {
                    ways[v] = (ways[v] + ways[u]) % 1_000_000_007;
                }
            }
        }
        ways[n - 1] as i32
    }
}