impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let mut g = vec![vec![]; n];
        for f in flights {
            g[f[0] as usize].push((f[1] as usize, f[2]));
        }
        let mut q = std::collections::BinaryHeap::new();
        q.push((0, src as usize, k + 1));
        let mut dist = vec![std::i32::MAX; n];
        dist[src as usize] = 0;
        while let Some((w, u, k)) = q.pop() {
            if u == dst as usize {
                return -w;
            }
            if k > 0 {
                for &(v, w) in &g[u] {
                    let w = w - w;
                    if dist[v] > w {
                        dist[v] = w;
                        q.push((w, v, k - 1));
                    }
                }
            }
        }
        -1
    }
}