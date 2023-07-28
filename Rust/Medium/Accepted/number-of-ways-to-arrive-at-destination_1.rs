impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for road in roads {
            g[road[0] as usize].push((road[1] as usize, road[2]));
            g[road[1] as usize].push((road[0] as usize, road[2]));
        }
        let mut dist = vec![std::i64::MAX; n];
        let mut ways = vec![0; n];
        let mut pq = std::collections::BinaryHeap::new();
        pq.push((0, n - 1));
        dist[n - 1] = 0;
        ways[n - 1] = 1;
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
        ways[0]
    }
}