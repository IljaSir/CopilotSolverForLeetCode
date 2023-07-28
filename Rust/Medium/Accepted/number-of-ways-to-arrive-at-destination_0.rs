impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for road in roads {
            graph[road[0] as usize].push((road[1] as usize, road[2]));
            graph[road[1] as usize].push((road[0] as usize, road[2]));
        }
        let mut dist = vec![std::i64::MAX; n];
        let mut cnt = vec![0; n];
        dist[0] = 0;
        cnt[0] = 1;
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((d, u))) = pq.pop() {
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &graph[u] {
                let d = d + w as i64;
                if d < dist[v] {
                    dist[v] = d;
                    cnt[v] = cnt[u];
                    pq.push(std::cmp::Reverse((d, v)));
                } else if d == dist[v] {
                    cnt[v] = (cnt[v] + cnt[u]) % 1_000_000_007;
                }
            }
        }
        cnt[n - 1] as i32
    }
}