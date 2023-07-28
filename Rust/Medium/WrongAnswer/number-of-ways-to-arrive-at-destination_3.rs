impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut graph: Vec<Vec<(usize, i32)>> = vec![vec![]; n];
        for road in roads {
            graph[road[0] as usize].push((road[1] as usize, road[2]));
            graph[road[1] as usize].push((road[0] as usize, road[2]));
        }
        let mut dist: Vec<i32> = vec![std::i32::MAX; n];
        let mut paths: Vec<i32> = vec![0; n];
        let mut pq: std::collections::BinaryHeap<(i32, usize)> = std::collections::BinaryHeap::new();
        pq.push((0, 0));
        dist[0] = 0;
        paths[0] = 1;
        while let Some((d, u)) = pq.pop() {
            if dist[u] < d {
                continue;
            }
            for (v, w) in &graph[u] {
                if dist[*v] > d + w {
                    dist[*v] = d + w;
                    paths[*v] = paths[u];
                    pq.push((dist[*v], *v));
                } else if dist[*v] == d + w {
                    paths[*v] = (paths[*v] + paths[u]) % 1_000_000_007;
                }
            }
        }
        paths[n - 1]
    }
}