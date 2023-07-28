impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut edges = vec![vec![]; n];
        for road in roads {
            let (u, v, t) = (road[0] as usize, road[1] as usize, road[2]);
            edges[u].push((v, t));
            edges[v].push((u, t));
        }
        let mut pq = std::collections::BinaryHeap::new();
        pq.push((0, 0, 0));
        let mut dist = vec![std::i64::MAX; n];
        let mut cnt = vec![0; n];
        dist[0] = 0;
        cnt[0] = 1;
        while let Some((d, u, c)) = pq.pop() {
            if d > dist[u] {
                continue;
            }
            if d == dist[u] {
                cnt[u] = (cnt[u] + c) % 1000000007;
            }
            for (v, t) in &edges[u] {
                let d = d + *t as i64;
                if d > dist[*v] {
                    continue;
                }
                if d < dist[*v] {
                    dist[*v] = d;
                    cnt[*v] = 0;
                }
                pq.push((d, *v, cnt[*v]));
            }
        }
        cnt[n - 1] as i32
    }
}