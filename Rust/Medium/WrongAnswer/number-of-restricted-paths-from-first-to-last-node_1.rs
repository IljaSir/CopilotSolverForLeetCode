impl Solution {
    pub fn count_restricted_paths(n: i32, edges: Vec<Vec<i32>>) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for e in edges {
            g[e[0] as usize - 1].push((e[1] as usize - 1, e[2]));
            g[e[1] as usize - 1].push((e[0] as usize - 1, e[2]));
        }
        let mut dist = vec![std::i32::MAX; n];
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(std::cmp::Reverse((0, n - 1)));
        while let Some(std::cmp::Reverse((d, u))) = pq.pop() {
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &g[u] {
                let d = d + w;
                if d < dist[v] {
                    dist[v] = d;
                    pq.push(std::cmp::Reverse((d, v)));
                }
            }
        }
        let mut dp = vec![0; n];
        dp[n - 1] = 1;
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(std::cmp::Reverse((dist[0], 0)));
        while let Some(std::cmp::Reverse((d, u))) = pq.pop() {
            if d > dist[u] {
                continue;
            }
            for &(v, w) in &g[u] {
                if dist[v] < dist[u] {
                    dp[v] = (dp[v] + dp[u]) % 1000000007;
                    pq.push(std::cmp::Reverse((dist[v], v)));
                }
            }
        }
        dp[0]
    }
}