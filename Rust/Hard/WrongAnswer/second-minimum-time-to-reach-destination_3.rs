impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for e in edges {
            let u = e[0] as usize - 1;
            let v = e[1] as usize - 1;
            graph[u].push(v);
            graph[v].push(u);
        }
        let mut dist = vec![std::i32::MAX; n];
        let mut q = std::collections::BinaryHeap::new();
        q.push((0, 0));
        while let Some((d, u)) = q.pop() {
            let d = -d;
            if dist[u] <= d {
                continue;
            }
            dist[u] = d;
            for &v in &graph[u] {
                let cycle = (d / change) % 2;
                let t = if cycle == 0 { time } else { change - d % change + time };
                q.push((-d - t, v));
            }
        }
        let mut ans = std::i32::MAX;
        for &d in &dist {
            if d < ans && d > dist[0] {
                ans = d;
            }
        }
        ans
    }
}