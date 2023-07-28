impl Solution {
    pub fn network_delay_time(times: Vec<Vec<i32>>, n: i32, k: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        for time in times {
            graph[time[0] as usize - 1].push((time[1] as usize - 1, time[2]));
        }
        let mut dist = vec![std::i32::MAX; n as usize];
        dist[k as usize - 1] = 0;
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(std::cmp::Reverse((0, k as usize - 1)));
        while let Some(std::cmp::Reverse((d, i))) = heap.pop() {
            if d > dist[i] { continue; }
            for &(j, w) in &graph[i] {
                if dist[j] > d + w {
                    dist[j] = d + w;
                    heap.push(std::cmp::Reverse((dist[j], j)));
                }
            }
        }
        dist.iter().max().cloned().unwrap_or(-1)
    }
}