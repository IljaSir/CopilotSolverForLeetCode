impl Solution {
    pub fn find_cheapest_price(n: i32, flights: Vec<Vec<i32>>, src: i32, dst: i32, k: i32) -> i32 {
        
        let mut graph = vec![vec![]; n as usize];
        let mut dist = vec![vec![std::i32::MAX; k as usize + 2]; n as usize];
        for flight in flights {
            graph[flight[0] as usize].push((flight[1], flight[2]));
        }
        let mut q = std::collections::BinaryHeap::new();
        q.push((0, src, k + 1));
        while let Some((cost, cur, k)) = q.pop() {
            let cost = -cost;
            if cur == dst {
                return cost;
            }
            if k > 0 {
                for (next, price) in &graph[cur as usize] {
                    if cost + price < dist[*next as usize][k as usize - 1] {
                        dist[*next as usize][k as usize - 1] = cost + price;
                        q.push((-(cost + price), *next, k - 1));
                    }
                }
            }
        }
        -1
    }
}