impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let n = n as usize;
        let src = src as usize;
        let dst = dst as usize;
        let k = k as usize;
        let mut adj = vec![vec![]; n];
        for flight in flights {
            let from = flight[0] as usize;
            let to = flight[1] as usize;
            let cost = flight[2] as usize;
            adj[from].push((to, cost));
        }
        let mut q = std::collections::BinaryHeap::new();
        let mut dist = vec![std::usize::MAX; n];
        q.push((0, src, k + 1));
        while let Some((cost, node, stops)) = q.pop() {
            if node == dst {
                return cost as i32;
            }
            if stops > 0 {
                for (to, cost) in &adj[node] {
                    let cost = cost + cost;
                    if cost < dist[*to] {
                        dist[*to] = cost;
                        q.push((cost, *to, stops - 1));
                    }
                }
            }
        }
        -1
    }
}