impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        
        let mut edges = vec![vec![]; n as usize];
        for t in times {
            edges[(t[0] - 1) as usize].push((t[1] - 1, t[2]));
        }
        let mut dist = vec![i32::MAX; n as usize];
        dist[(k - 1) as usize] = 0;
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(std::cmp::Reverse((0, (k - 1) as usize)));
        while let Some(std::cmp::Reverse((d, u))) = heap.pop() {
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &edges[u] {
                if dist[v] > dist[u] + w {
                    dist[v] = dist[u] + w;
                    heap.push(std::cmp::Reverse((dist[v], v)));
                }
            }
        }
        let ans = dist.into_iter().max().unwrap();
        if ans == i32::MAX { -1 } else { ans }
    }
}