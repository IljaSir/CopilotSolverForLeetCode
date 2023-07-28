impl Solution {
    pub fn count_paths(n: i32, roads: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        let mut dist = vec![std::i64::MAX; n];
        let mut count = vec![0; n];
        let mut heap = std::collections::BinaryHeap::new();
        count[0] = 1;
        dist[0] = 0;
        for road in roads {
            graph[road[0] as usize].push((road[1] as usize, road[2] as i64));
            graph[road[1] as usize].push((road[0] as usize, road[2] as i64));
        }
        heap.push((0, 0));
        while let Some((w, u)) = heap.pop() {
            let w = -w;
            if w > dist[u] {
                continue;
            }
            for &(v, w) in &graph[u] {
                if w + dist[u] < dist[v] {
                    dist[v] = w + dist[u];
                    count[v] = count[u];
                    heap.push((-dist[v], v));
                } else if w + dist[u] == dist[v] {
                    count[v] = (count[v] + count[u]) % 1_000_000_007;
                }
            }
        }
        count[n - 1] as i32
    }
}