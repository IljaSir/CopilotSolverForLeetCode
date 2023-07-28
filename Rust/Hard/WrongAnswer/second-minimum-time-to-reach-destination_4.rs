impl Solution {
    pub fn second_minimum(n: i32, edges: Vec<Vec<i32>>, time: i32, change: i32) -> i32 {
        
        let n = n as usize;
        let mut graph = vec![vec![]; n];
        for edge in edges {
            let (u, v) = (edge[0] as usize - 1, edge[1] as usize - 1);
            graph[u].push(v);
            graph[v].push(u);
        }
        let mut dist = vec![vec![std::i32::MAX; 2]; n];
        dist[0][0] = 0;
        let mut q = std::collections::BinaryHeap::new();
        q.push((std::cmp::Reverse(0), 0, 0));
        while let Some((std::cmp::Reverse(d), u, f)) = q.pop() {
            if d > dist[u][f] {
                continue;
            }
            for &v in &graph[u] {
                let (d, f) = if f == 0 {
                    (d + time, 1)
                } else {
                    let t = (d + time) % (2 * change);
                    if t <= change {
                        (d + time + change - t, 0)
                    } else {
                        (d + time + 2 * change - t, 1)
                    }
                };
                if d < dist[v][f] {
                    dist[v][f] = d;
                    q.push((std::cmp::Reverse(d), v, f));
                }
            }
        }
        dist[n - 1][1]
    }
}