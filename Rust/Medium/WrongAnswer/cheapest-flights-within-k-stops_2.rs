impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let src = src as usize;
        let dst = dst as usize;
        let k = k as usize;
        let mut graph = vec![vec![]; n];
        for f in flights {
            graph[f[0] as usize].push((f[1] as usize, f[2]));
        }
        let mut dist = vec![std::i32::MAX; n];
        dist[src] = 0;
        let mut q = std::collections::BinaryHeap::new();
        q.push(std::cmp::Reverse((0, src, k + 1)));
        while let Some(std::cmp::Reverse((price, u, k))) = q.pop() {
            if u == dst {
                return price;
            }
            if k > 0 {
                for &(v, w) in &graph[u] {
                    let new_price = price + w;
                    if new_price < dist[v] {
                        dist[v] = new_price;
                        q.push(std::cmp::Reverse((new_price, v, k - 1)));
                    }
                }
            }
        }
        -1
    }
}