impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut dist = vec![std::i64::MAX; n];
        let mut ways = vec![0; n];
        let mut graph = vec![Vec::new(); n];
        for road in roads {
            let (u, v, w) = (road[0] as usize, road[1] as usize, road[2]);
            graph[u].push((v, w));
            graph[v].push((u, w));
        }
        dist[0] = 0;
        ways[0] = 1;
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(std::cmp::Reverse((0, 0)));
        while let Some(std::cmp::Reverse((d, u))) = pq.pop() {
            if d > dist[u] { continue; }
            for &(v, w) in &graph[u] {
                let d = d + w as i64;
                if d < dist[v] {
                    dist[v] = d;
                    ways[v] = ways[u];
                    pq.push(std::cmp::Reverse((d, v)));
                } else if d == dist[v] {
                    ways[v] = (ways[v] + ways[u]) % 1000000007;
                }
            }
        }
        ways[n - 1] as i32
    }
}